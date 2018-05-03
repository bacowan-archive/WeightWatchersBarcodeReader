package moe.cowan.brendan.weightwatchersbarcodereader.View

import ViewModel.MainActivityViewModel
import ViewModel.ResultsViewModel
import ViewModel.SearchResultDisplayer
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import moe.cowan.brendan.weightwatchersbarcodereader.R
import moe.cowan.brendan.weightwatchersbarcodereader.databinding.ResultsActivityBinding

const val UPC_MESSAGE = "moe.cowan.brendan.weightwatchersbarcodereader.View.UPC_MESSAGE"

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ResultsActivityBinding>(this, R.layout.results_activity)

        val message = intent.getStringExtra(UPC_MESSAGE)

        val vm = ResultsViewModel(message)
        vm.loadProductData()
        binding.vm = vm
        binding.executePendingBindings()
    }
}