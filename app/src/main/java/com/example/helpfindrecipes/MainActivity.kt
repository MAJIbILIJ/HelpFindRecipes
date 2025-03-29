package com.example.helpfindrecipes

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.helpfindrecipes.adapter.RecipeAdapter
import com.example.helpfindrecipes.databinding.ActivityMainBinding
import com.example.recipes.retrofit.RecipeApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RecipeAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        adapter = RecipeAdapter()
        binding.rcView.layoutManager = LinearLayoutManager(this)
        binding.rcView.adapter = adapter


        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

//        val tv = findViewById<TextView>(R.id.tv)
//        val b = findViewById<Button>(R.id.button)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()
        val recipeApi = retrofit.create(RecipeApi::class.java)



        binding.sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(text: String?): Boolean {
                CoroutineScope(Dispatchers.IO).launch() {
                    val list = text?.let { recipeApi.getRecipesByName(it) }
//            val recipe = recipeApi.getRecipeById(3)
                    runOnUiThread {

                        binding.apply{
                            adapter.submitList(list?.recipes)
                        }
                    }
                }
                return true
            }

        })



//        binding.button.setOnClickListener {
//            CoroutineScope(Dispatchers.IO).launch() {
//                val recipe = recipeApi.getRecipeById(3)
//                runOnUiThread {
//                    tv.text = recipe.name
//                }
//            }
//        }



    }
}