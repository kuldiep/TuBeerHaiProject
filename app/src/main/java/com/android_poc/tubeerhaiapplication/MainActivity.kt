package com.android_poc.tubeerhaiapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.android_poc.tubeerhaiapplication.databinding.ActivityMainBinding
import com.android_poc.tubeerhaiapplication.recyclerutils.BeerListingRecyclerViewAdapter
import com.android_poc.tubeerhaiapplication.utility.AppConstants
import com.android_poc.tubeerhaiapplication.viewmodel.BeerListingViewModel

class MainActivity : AppCompatActivity() {
   private var mainActivityMainBinding:ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        mainActivityMainBinding?.rvListOfBeers?.layoutManager = LinearLayoutManager(this)
        mainActivityMainBinding?.rvListOfBeers?.itemAnimator = DefaultItemAnimator()

        val beerListingRecyclerViewAdapter = BeerListingRecyclerViewAdapter(arrayListOf(),this)
        mainActivityMainBinding?.rvListOfBeers?.adapter = beerListingRecyclerViewAdapter
        val beerListingViewModel by viewModels<BeerListingViewModel>()

        beerListingViewModel.makeNetworkCallFromRepository(AppConstants.INITIAL_PAGE_SIZE)

        beerListingViewModel.getApiCallBackListenerLiveData().observe(this,{
            if(!it){
                Toast.makeText(this,"Something went wrong",Toast.LENGTH_LONG).show()
            }
        })

        beerListingViewModel.getBeerListFromRepository().observe(this,{
            if(it.isNotEmpty()){
                beerListingRecyclerViewAdapter.setBeerRootRespTOListFromUi(it)
            }
        })
    }
}