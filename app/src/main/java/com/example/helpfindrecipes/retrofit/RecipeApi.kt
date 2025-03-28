package com.example.recipes.retrofit

import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeApi {
    @GET("recipes/{id}")
    suspend fun getRecipeById(@Path("id") id: Int): Recipe

}