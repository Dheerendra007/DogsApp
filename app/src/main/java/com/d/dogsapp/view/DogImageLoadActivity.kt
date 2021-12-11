package com.d.dogsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.d.dogsapp.R
import com.d.dogsapp.api.DogService
import com.d.dogsapp.api.RetrofitHelper
import com.d.dogsapp.databinding.ActivityDogImageLoadBinding
import com.d.dogsapp.models.DogsImage
import com.d.dogsapp.repository.DogRepository
import com.d.dogsapp.utils.TinyDB
import com.d.dogsapp.viewmodels.DogImageLoadViewModel
import com.d.dogsapp.viewmodels.DogImageLoadViewModelFactory
import kotlinx.coroutines.launch


class DogImageLoadActivity : AppCompatActivity() {

    lateinit var binding: ActivityDogImageLoadBinding
    lateinit var dogImageLoadViewModel : DogImageLoadViewModel
    var arrayList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_dog_image_load)
        var tinyDB : TinyDB = TinyDB(applicationContext)
        val dogServices = RetrofitHelper.getInstance().create(DogService::class.java)

        val repository = DogRepository(dogServices)

        dogImageLoadViewModel = ViewModelProvider(this,
            DogImageLoadViewModelFactory(repository,tinyDB)).get(DogImageLoadViewModel::class.java)

        dogImageLoadViewModel.dogImgs.observe(this, Observer {
            Log.d("DogImageLoadActivity",it.message)
            Glide
                .with(this)
                .load(it.message)
                .centerCrop()
                .placeholder(R.drawable.loading)
                .into(binding.ivDogImage);
            arrayList.add(it.message)
            tinyDB.putListString("dogArrayList",arrayList)
        })
    }

    fun onClickGenerate(view: View) {
        dogImageLoadViewModel.updateData()
    }
}