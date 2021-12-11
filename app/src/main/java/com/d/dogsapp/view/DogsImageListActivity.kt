package com.d.dogsapp.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.d.dogsapp.R
import com.d.dogsapp.databinding.ActivityDogsImageListBinding
import com.d.dogsapp.utils.TinyDB
import com.d.dogsapp.viewmodels.DogImageLoadViewModel
import com.d.dogsapp.viewmodels.DogImageLoadViewModelFactory
import com.d.dogsapp.viewmodels.DogsImageLoadListViewModel
import com.d.dogsapp.viewmodels.DogsImageLoadListViewModelFactory
import android.os.Looper




class DogsImageListActivity : AppCompatActivity() {

    lateinit var binding: ActivityDogsImageListBinding
    lateinit var dogsImageLoadListViewModel:DogsImageLoadListViewModel
    private var viewManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_dogs_image_list)
        var tinyDB : TinyDB = TinyDB(applicationContext)
        dogsImageLoadListViewModel = ViewModelProvider(this,
            DogsImageLoadListViewModelFactory(tinyDB)
        ).get(DogsImageLoadListViewModel::class.java)

        initialiseAdapter()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun onClickClearDogs(view: View) {
        dogsImageLoadListViewModel.clearData()
        dogsImageLoadListViewModel.dogImgsList.observe(this, Observer {
            binding.recyclerview.adapter?.notifyDataSetChanged()
        })
    }

    private fun initialiseAdapter(){
        binding.recyclerview.layoutManager = viewManager
        observeData()
    }

    fun observeData(){
        dogsImageLoadListViewModel.dogImgsList.observe(this, Observer {
            binding.recyclerview.adapter= DogImageListAdapter(dogsImageLoadListViewModel, it, this)
        })
    }
}