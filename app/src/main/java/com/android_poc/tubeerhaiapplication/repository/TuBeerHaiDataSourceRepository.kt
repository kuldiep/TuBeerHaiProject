package com.android_poc.tubeerhaiapplication.repository

import BeerRootRespTO
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android_poc.tubeerhaiapplication.networking.ApiCallbackListener
import com.android_poc.tubeerhaiapplication.networking.BeerRetrofitApiClient
import com.android_poc.tubeerhaiapplication.networking.FetchBeerApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TuBeerHaiDataSourceRepository {

    private var beerRootRespTOMutableList  = MutableLiveData<List<BeerRootRespTO>>()
    private object HOLDER {
        val INSTANCE = TuBeerHaiDataSourceRepository()
    }

    companion object {
        fun getTuBeerHaiDataSourceRepository(): TuBeerHaiDataSourceRepository {
            val instance: TuBeerHaiDataSourceRepository by lazy { HOLDER.INSTANCE }
            return instance
        }
    }
    fun getFirstPageOfBeerFromNetwork(pageSize:Int,apiCallbackListener: ApiCallbackListener){
        Log.d("LOG","intoRepo method")
        val fetchBeerApiService = BeerRetrofitApiClient.buildService(FetchBeerApiService::class.java)

        fetchBeerApiService.getPagedListBeersFromNetwork(pageSize).enqueue(object :Callback<List<BeerRootRespTO>>{
            override fun onResponse(call: Call<List<BeerRootRespTO>>,
                                    response: Response<List<BeerRootRespTO>>) {
                if(response.isSuccessful) {
                    apiCallbackListener.isApiCallSuccessfull(true)
                    beerRootRespTOMutableList.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<BeerRootRespTO>>, t: Throwable) {
                apiCallbackListener.isApiCallSuccessfull(false)
                Log.e("LOG","Exception ..",t)
            }
        })
    }

    fun getMutableLiveBeerRootRespTOList():LiveData<List<BeerRootRespTO>>{
        Log.d("LOG","into method")
        return beerRootRespTOMutableList
    }
}