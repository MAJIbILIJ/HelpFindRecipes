package com.example.recipes.retrofit

import retrofit2.http.GET

interface RecipeApi {
    @GET("/recipes/1")
    suspend fun getRecipeById(): Recipe

}