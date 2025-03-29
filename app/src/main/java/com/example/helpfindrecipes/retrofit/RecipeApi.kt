package com.example.recipes.retrofit

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RecipeApi {
    @GET("recipes/{id}")
    suspend fun getRecipeById(@Path("id") id: Int): Recipe

//    @POST("auth/login")
//    suspend fun auth(@Body authRequest: AuthRequest): User

    @GET("recipes")
    suspend fun getAllRecipes(): Recipes
}