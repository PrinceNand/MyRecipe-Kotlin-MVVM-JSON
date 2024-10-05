package com.example.myrecipe_kotlin_mvvm_json

//API: www.themealdb.com/api/json/v1/1/categories.php

data class Category (val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
    )

// get a list of individual category item i.e., Categories
data class CategoriesResponse(val categories: List<Category>)