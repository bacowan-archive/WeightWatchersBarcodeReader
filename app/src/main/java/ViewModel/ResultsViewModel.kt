package ViewModel

import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR

class ResultsViewModel(upc: String) : BaseObservableViewModel() {
    @Bindable
    var productName : String = ""
        set (value) {
            field = value
            notifyPropertyChanged(BR.productName)
        }

    @Bindable
    var points : Int = 0
        set (value) {
            field = value
            notifyPropertyChanged(BR.points)
        }

    fun loadProductData() {

    }
}