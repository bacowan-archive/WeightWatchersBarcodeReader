package moe.cowan.brendan.weightwatchersbarcodereader.View

import ViewModel.MainActivityViewModel
import ViewModel.SearchResultDisplayer
import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import moe.cowan.brendan.weightwatchersbarcodereader.R
import moe.cowan.brendan.weightwatchersbarcodereader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.vm = MainActivityViewModel(object : SearchResultDisplayer{
            override fun display(upc: String) {
                val intent = Intent(this@MainActivity, ResultsActivity::class.java).apply {
                    putExtra(UPC_MESSAGE, upc)
                }
                startActivity(intent)
            }
        })
        binding.executePendingBindings()
    }
}
