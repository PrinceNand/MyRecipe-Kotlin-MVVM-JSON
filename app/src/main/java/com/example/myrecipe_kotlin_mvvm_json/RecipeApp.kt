package com.example.myrecipe_kotlin_mvvm_json

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController){

    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route){
        composable(route = Screen.RecipeScreen.route){

            //for first screen
            RecipeScreen(viewState = viewState, navigateToDetails = {
                // setting the viewState single category data in controller
                //this part part is responsible for passing data from the current screen to the details screen.
                // It utilizes the savedStateHandle, which is a component of the compose navigation framework.
                navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)

                // sending to next screen
                navController.navigate(Screen.DetailScreen.route)
            })
        }

        //for second screen
        composable(route = Screen.DetailScreen.route){
            // get the value which is set in first screen
            val category = navController.previousBackStackEntry?.savedStateHandle?.
            get<Category>("cat")?: Category("", "" ,"", "")
            CategoryDetailScreen(category= category)
        }
    }
}