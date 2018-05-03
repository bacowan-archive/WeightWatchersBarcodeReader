package ViewModel

import android.databinding.Bindable

class MainActivityViewModel(val searchResultDisplayer: SearchResultDisplayer) : BaseObservableViewModel() {
    @Bindable
    var upc : String = ""
        set(value) {
            field = value
        }

    fun searchClick() {
        searchResultDisplayer.display(upc)
    }
}