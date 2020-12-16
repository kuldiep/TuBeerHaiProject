package com.android_poc.tubeerhaiapplication.networking

import BeerRootRespTO
import com.android_poc.tubeerhaiapplication.utility.AppConstants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FetchBeerApiService {
    @GET(AppConstants.END_POINT)
    fun getPagedListBeersFromNetwork(@Query("page") page:Int) : Call<List<BeerRootRespTO>>
}