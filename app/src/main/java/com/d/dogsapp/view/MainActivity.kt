package com.d.dogsapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.d.dogsapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickGenerateDogs(view: View) {
        startActivity(Intent(this, DogImageLoadActivity::class.java))
    }

    fun onClickMyRecentGenerateDogs(view: View) {
        startActivity(Intent(this, DogsImageListActivity::class.java))
    }
}