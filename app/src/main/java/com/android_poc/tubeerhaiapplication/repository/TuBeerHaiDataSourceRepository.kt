package com.android_poc.tubeerhaiapplication.repository

import BeerRootRespTO
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android_poc.tubeerhaiapplication.networking.BeerRetrofitApiClient
import com.android_poc.tubeerhaiapplication.networking.FetchBeerApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TuBeerHaiDataSourceRepository {

    private var beerRootRespTOMutableList  = MutableLiveData<List<BeerRootRespTO>>()

    fun getFirstPageOfBeerFromNetwork(pageSize:Int){
        Log.d("LOG","intoRepo method")
        val fetchBeerApiService = BeerRetrofitApiClient.buildService(FetchBeerApiService::class.java)

        fetchBeerApiService.getPagedListBeersFromNetwork(pageSize).enqueue(object :Callback<List<BeerRootRespTO>>{
            override fun onResponse(
                call: Call<List<BeerRootRespTO>>, response: Response<List<BeerRootRespTO>>) {
                Log.d("LOG","Onresponse")
                beerRootRespTOMutableList.value = response.body()
            }

            override fun onFailure(call: Call<List<BeerRootRespTO>>, t: Throwable) {
                Log.e("LOG","Exception ..",t)
            }
        })
    }

    fun getMutableLiveBeerRootRespTOList():LiveData<List<BeerRootRespTO>>{
        Log.d("LOG","into method")
        return beerRootRespTOMutableList
    }
}