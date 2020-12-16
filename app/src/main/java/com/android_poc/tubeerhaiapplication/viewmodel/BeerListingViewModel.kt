package com.android_poc.tubeerhaiapplication.viewmodel

import BeerRootRespTO
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android_poc.tubeerhaiapplication.repository.TuBeerHaiDataSourceRepository

class BeerListingViewModel : ViewModel() {
    private val tuBeerHaiDataSourceRepository = TuBeerHaiDataSourceRepository()

    fun makeNetworkCallFromRepository(pageSize:Int){
        tuBeerHaiDataSourceRepository.getFirstPageOfBeerFromNetwork(pageSize)
    }

    fun getBeerListFromRepository():LiveData<List<BeerRootRespTO>>{
        return tuBeerHaiDataSourceRepository.getMutableLiveBeerRootRespTOList()
    }
}