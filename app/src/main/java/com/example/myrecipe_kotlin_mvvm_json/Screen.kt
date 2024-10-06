package com.example.myrecipe_kotlin_mvvm_json


// sealed used to handle error if the route name is typed incorrectly

sealed class Screen(val route:String) {

    object RecipeScreen:Screen("recipescreen")
    object DetailScreen:Screen("detailscreen")

}