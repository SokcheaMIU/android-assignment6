package com.example.assignment6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_recipe.*

class RecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        title = "Recipe"
        val food = intent.getSerializableExtra("food") as Food
        details_image.setImageResource(food.image)
        details_name.text = food.name
        recipe.text = food.recipe
    }
}