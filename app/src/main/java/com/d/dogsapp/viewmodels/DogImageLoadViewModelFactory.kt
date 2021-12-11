package com.d.dogsapp.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.d.dogsapp.repository.DogRepository
import com.d.dogsapp.utils.TinyDB

class DogImageLoadViewModelFactory(private val repository: DogRepository, var tinyDB : TinyDB) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DogImageLoadViewModel(repository,tinyDB) as T
    }
}