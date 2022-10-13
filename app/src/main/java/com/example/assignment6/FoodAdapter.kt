package com.example.assignment6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.food_list_item.view.*

class FoodAdapter(private val foods: List<Food>, private val clickListener: (food: Food) -> Unit)
    : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_list_item, parent, false)
        return  FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.itemView.imageView.setImageResource(foods[position].image)
        holder.itemView.name.text = foods[position].name

        holder.itemView.setOnClickListener() {
            clickListener(foods[position])
        }
    }

    override fun getItemCount() = foods.count()

    inner class FoodViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) { }
}