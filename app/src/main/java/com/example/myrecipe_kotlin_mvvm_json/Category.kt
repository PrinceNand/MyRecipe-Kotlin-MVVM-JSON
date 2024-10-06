package com.example.myrecipe_kotlin_mvvm_json

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//API: www.themealdb.com/api/json/v1/1/categories.php

@Parcelize
data class Category (val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String): Parcelable


// get a list of individual category item i.e., Categories
data class CategoriesResponse(val categories: List<Category>)

/*
Parcelize is a Kotlin feature that simplifies the implementation of the Parcelable interface,
which allows objects to be serialized and passed between Android components like activities and
fragments. By using the @Parcelize annotation on data classes, developers can automatically
generate the necessary serialization code, reducing boilerplate and improving code readability.
This approach enhances performance compared to Java's Serializable and leverages Kotlin’s type safety,
making it easier to manage complex data structures
while ensuring efficient data transfer in Android applications.*/

/*Ex:
plugins {
    id 'kotlin-android'
    id 'kotlin-parcelize'
}
@Parcelize
data class User(
    val id: Int,
    val name: String,
    val email: String
) : Parcelable*/
