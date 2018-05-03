package ViewModel;

import android.arch.lifecycle.ViewModel;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;

/**
 * BaseObservable (https://android.googlesource.com/platform/frameworks/data-binding/+/c9a5d6f140f732ca0ff279a4b1ee315072e1c422/library/src/main/java/android/databinding/BaseObservable.java)
 * with modifications as per https://medium.com/@dpreussler/add-the-new-viewmodel-to-your-mvvm-36bfea86b159
 */

public class BaseObservableViewModel extends ViewModel implements Observable {
    private transient PropertyChangeRegistry mCallbacks;
    public BaseObservableViewModel() {
    }
    @Override
    public synchronized void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (mCallbacks == null) {
            mCallbacks = new PropertyChangeRegistry();
        }
        mCallbacks.add(callback);
    }
    @Override
    public synchronized void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (mCallbacks != null) {
            mCallbacks.remove(callback);
        }
    }
    /**
     * Notifies listeners that all properties of this instance have changed.
     */
    public synchronized void notifyChange() {
        if (mCallbacks != null) {
            mCallbacks.notifyCallbacks(this, 0, null);
        }
    }
    /**
     * Notifies listeners that a specific property has changed. The getter for the property
     * that changes should be marked with Bindable to generate a field in
     * <code>BR</code> to be used as <code>fieldId</code>.
     *
     * @param fieldId The generated BR id for the Bindable field.
     */
    public void notifyPropertyChanged(int fieldId) {
        if (mCallbacks != null) {
            mCallbacks.notifyCallbacks(this, fieldId, null);
        }
    }
}