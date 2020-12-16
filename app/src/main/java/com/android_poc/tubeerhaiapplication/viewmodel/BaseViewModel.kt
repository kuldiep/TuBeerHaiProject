package com.android_poc.tubeerhaiapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.android_poc.tubeerhaiapplication.repository.TuBeerHaiDataSourceRepository

open class BaseViewModel : ViewModel() {
    fun getRepositoryInstance():TuBeerHaiDataSourceRepository{
        return TuBeerHaiDataSourceRepository.getTuBeerHaiDataSourceRepository()
    }
}