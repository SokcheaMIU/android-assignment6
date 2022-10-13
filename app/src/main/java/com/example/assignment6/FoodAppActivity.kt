package com.example.assignment6

import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_food_app.*

class FoodAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_app)

        title = "Food App"
        val foods = generateFoods()
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val foodAdapter = FoodAdapter(foods, clickListener = { food ->
            showRecipe(food)
        })

        recyclerView.adapter = foodAdapter
        recyclerView.addItemDecoration(FoodItemDecoration())
    }

    private fun generateFoods(): List<Food> {
        val food1 = Food("Coffee", getString(R.string.coffee_recipe), R.drawable.coffee_pot)
        val food2 = Food("Espresso", getString(R.string.espresso_recipe), R.drawable.espresso)
        val food3 = Food("French Fires", getString(R.string.french_fries_recipe), R.drawable.french_fries)
        val food4 = Food("Honey", getString(R.string.honey_recipe), R.drawable.honey)
        val food5 = Food("Strawberry", getString(R.string.strawberry_recipe) , R.drawable.strawberry_ice_cream)
        val food6 = Food("Sugar cubes", getString(R.string.sugar_cubes), R.drawable.sugar_cubes)

        return listOf(food1, food2, food3, food4, food5, food6)
    }

    private fun showRecipe(food: Food) {
        val intent = Intent(this, RecipeActivity::class.java)
        intent.putExtra("food", food)

        startActivity(intent)
    }

    inner class FoodItemDecoration(): RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.left = 20
            outRect.right = 20
            outRect.top = 20
            outRect.bottom = 20
        }
    }
}