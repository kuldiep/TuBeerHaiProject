package com.android_poc.tubeerhaiapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android_poc.tubeerhaiapplication.viewmodel.BeerListingViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val beerListingViewModel:BeerListingViewModel by viewModels<BeerListingViewModel>()
        beerListingViewModel.makeNetworkCallFromRepository(1)
        beerListingViewModel.getBeerListFromRepository().observe(this,{
            Log.d("LOG","response got from server is "+it.toString())
        })
    }
}