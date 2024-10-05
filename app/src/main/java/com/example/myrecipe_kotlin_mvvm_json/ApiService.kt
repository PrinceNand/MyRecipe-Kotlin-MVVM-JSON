package com.example.myrecipe_kotlin_mvvm_json

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


// Get Base URL using  Retrofit Builder and convert in Gson
private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

// store it in a variable
val recipeService = retrofit.create(ApiService::class.java)

interface ApiService{

    @GET("categories.php")
    suspend fun getCategories():CategoriesResponse
}

// Coroutine: Used for handling asynchronous and non-blocking operation

/* Suspend: Suspending functions are at the center of everything coroutines.
A suspending function is simply a function that can be paused and resumed at a later time.
They can execute a long running operation and wait for it to complete without blocking.*/
