package com.d.dogsapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.d.dogsapp.api.DogService
import com.d.dogsapp.models.DogsImage

class DogRepository(private val dogService : DogService) {

    private val dogImageLiveData = MutableLiveData<DogsImage>()

    val dogsImg:LiveData<DogsImage>
    get() = dogImageLiveData

    suspend fun getDogImages(){
        //call API service
        val result = dogService.getDogImage()
        if (result?.body() != null){
          dogImageLiveData.postValue(result.body())
        }
    }
}