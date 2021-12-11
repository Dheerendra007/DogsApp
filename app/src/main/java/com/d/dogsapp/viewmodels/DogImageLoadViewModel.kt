package com.d.dogsapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d.dogsapp.models.DogsImage
import com.d.dogsapp.repository.DogRepository
import com.d.dogsapp.utils.TinyDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher


class DogImageLoadViewModel(private val repository: DogRepository, var tinyDB : TinyDB ):ViewModel() {


    init {
            viewModelScope.launch(Dispatchers.IO) {
                repository.getDogImages()
            }
    }

    fun updateData(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getDogImages()
        }
    }

    val dogImgs : LiveData<DogsImage>
    get() = repository.dogsImg
}