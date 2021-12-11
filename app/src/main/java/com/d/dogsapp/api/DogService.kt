package com.d.dogsapp.api

import com.d.dogsapp.models.DogsImage
import retrofit2.Response
import retrofit2.http.GET

interface DogService {

    @GET("breeds/image/random")
    suspend fun getDogImage() : Response<DogsImage>
}