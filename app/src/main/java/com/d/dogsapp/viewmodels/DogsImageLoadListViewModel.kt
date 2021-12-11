package com.d.dogsapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d.dogsapp.models.DogsImage
import com.d.dogsapp.repository.DogRepository
import com.d.dogsapp.utils.TinyDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DogsImageLoadListViewModel(var tinyDB : TinyDB): ViewModel() {

    var lst = MutableLiveData<ArrayList<String>>()
    var newlist = arrayListOf<String>()


    fun getData() : MutableLiveData<ArrayList<String>> {
        lst.value=tinyDB.getListString("dogArrayList")
        return   lst
    }

    fun clearData() {
       // tinyDB.putListString("dogArrayList",newlist)
        return   tinyDB.clear()
    }

    var dogImgsList = MutableLiveData<ArrayList<String>>()
        get() = getData()

}