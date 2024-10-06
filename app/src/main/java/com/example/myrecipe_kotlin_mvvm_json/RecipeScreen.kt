package com.example.myrecipe_kotlin_mvvm_json

import android.telecom.Call.Details
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter


@Composable
fun RecipeScreen(
    modifier: Modifier = Modifier,

    //navigation from the nav controller click
    navigateToDetails: (Category)-> Unit,

    // sending data from Recipe App based on the navigation
    viewState:MainViewModel.RecipeState
) {
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            viewState.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            viewState.error != null -> {
                Text("Error Occured!")
            }

            else -> {
                // Display Categories
                CategoryScreen(categories = viewState.list, navigateToDetails)
            }
        }
    }
}

// handle a list to show the data and 2 data at a time
@Composable
fun CategoryScreen(categories: List<Category>, navigateToDetails: (Category)-> Unit){
    LazyVerticalGrid(GridCells.Fixed(2), modifier =  Modifier.fillMaxSize()) {

        // get each item and send to category single item UI
        items(categories){
            category -> CategoryItems(category, navigateToDetails)
        }

    }
}

// how am item will look like
@Composable
fun CategoryItems(category: Category, navigateToDetails: (Category)-> Unit){
    Column(modifier = Modifier.padding(8.dp).fillMaxSize()
        .clickable { navigateToDetails(category) },
        horizontalAlignment = Alignment.CenterHorizontally) {

        // how image should look
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier.fillMaxSize().aspectRatio(1f)
        )


        // how text should look
        Text(
            text = category.strCategory,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}