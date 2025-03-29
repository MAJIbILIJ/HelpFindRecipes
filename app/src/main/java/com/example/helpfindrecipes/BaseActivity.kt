package com.example.helpfindrecipes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.helpfindrecipes.adapter.RecipeAdapter
import com.example.helpfindrecipes.databinding.ContentBaseBinding


class BaseActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var adapter: RecipeAdapter
    private lateinit var binding: ContentBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContentBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)





    }


}