package com.example.recipes.retrofit

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeApi {
    @GET("recipes/{id}")
    suspend fun getRecipeById(@Path("id") id: Int): Recipe


    @GET("recipes")
    suspend fun getAllRecipes(): Recipes

    @GET("recipes/search")
    suspend fun getRecipesByName(@Query("q") name: String): Recipes



}
