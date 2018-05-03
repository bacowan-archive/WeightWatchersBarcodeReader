package ViewModel

import android.databinding.Bindable

class MainActivityViewModel : BaseObservableViewModel() {
    @Bindable
    var upc : String = ""
        set(value) {
            field = value
        }

    fun searchClick() {

    }
}