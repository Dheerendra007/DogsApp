package com.d.dogsapp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.adapters.AdapterViewBindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.d.dogsapp.R
import com.d.dogsapp.databinding.ActivityDogImageLoadBinding.inflate
import com.d.dogsapp.databinding.ActivityDogsImageListBinding.inflate
import com.d.dogsapp.models.DogsImage
import com.d.dogsapp.viewmodels.DogsImageLoadListViewModel
import kotlinx.coroutines.NonDisposableHandle.parent

class DogImageListAdapter(val viewModel: DogsImageLoadListViewModel,
                          val arrayList: ArrayList<String>, val context: Context
): RecyclerView.Adapter<DogImageListAdapter.
NotesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): DogImageListAdapter.NotesViewHolder {
        var root = LayoutInflater.from(parent.context).inflate(R.layout.adapter_dogs_image,parent,false)
        return NotesViewHolder(root)
    }

    override fun onBindViewHolder(holder: DogImageListAdapter.NotesViewHolder, position: Int) {
        holder.bind(arrayList.get(position))
    }

    override fun getItemCount(): Int {
        if(arrayList.size==0){
        }else{

        }
        return arrayList.size
    }

    inner  class NotesViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {
        fun bind(url: String){
            Glide
                .with(context)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.loading)
                .into(binding.findViewById(R.id.ivDogImage));

        }

    }

}