package com.example.fitplate_dienams

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(
    private val foods: List<FoodItem>,
    private val onItemClick: (FoodItem) -> Unit
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodIcon: ImageView = itemView.findViewById(R.id.foodIcon)
        val foodName: TextView = itemView.findViewById(R.id.foodName)
        val mealTime: TextView = itemView.findViewById(R.id.mealTime)
        val detailText: TextView = itemView.findViewById(R.id.detailText)
        val chevronIcon: ImageView = itemView.findViewById(R.id.chevronIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foods[position]

        // Bind the food data to the views
        holder.foodName.text = food.name
        holder.mealTime.text = food.mealTime

        // Handle the item click with the appropriate intent
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailFoodActivity::class.java).apply {
                putExtra("food_id", food.id)
                putExtra("food_name", food.name)
                putExtra("meal_time", food.mealTime)
                putExtra("calories", food.calories)
                putExtra("carbs", food.carbs)
                putExtra("protein", food.protein)
                putExtra("fat", food.fat)
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = foods.size
}


