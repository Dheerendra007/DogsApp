package com.d.dogsapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.d.dogsapp.repository.DogRepository
import com.d.dogsapp.utils.TinyDB

class DogsImageLoadListViewModelFactory(var tinyDB : TinyDB):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DogsImageLoadListViewModel(tinyDB) as T
    }
}