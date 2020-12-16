package com.android_poc.tubeerhaiapplication.viewmodel

import BeerRootRespTO
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android_poc.tubeerhaiapplication.networking.ApiCallbackListener

class BeerListingViewModel : BaseViewModel() {

    var mutableLiveDataApiCallbackListenerFlag = MutableLiveData<Boolean>()

    fun makeNetworkCallFromRepository(pageSize:Int){

        val apiCallbackListener = object :ApiCallbackListener{
            override fun isApiCallSuccessfull(flag: Boolean) {
                mutableLiveDataApiCallbackListenerFlag.value = flag
            }
        }
        getRepositoryInstance().getFirstPageOfBeerFromNetwork(pageSize,apiCallbackListener)
    }

    fun getBeerListFromRepository():LiveData<List<BeerRootRespTO>>{
        return getRepositoryInstance().getMutableLiveBeerRootRespTOList()
    }

    fun getApiCallBackListenerLiveData():LiveData<Boolean>{
        return mutableLiveDataApiCallbackListenerFlag
    }

}