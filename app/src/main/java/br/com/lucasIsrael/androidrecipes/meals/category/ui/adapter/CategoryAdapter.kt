package br.com.lucasIsrael.androidrecipes.meals.category.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.lucasIsrael.androidrecipes.R
import br.com.lucasIsrael.androidrecipes.databinding.ListItemMealsBinding
import br.com.lucasIsrael.androidrecipes.meals.category.data.model.CategoryMeal
import br.com.lucasIsrael.androidrecipes.meals.category.data.model.Meals
import coil.load
import coil.transform.CircleCropTransformation

class CategoryAdapter(private val meals: Meals) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private lateinit var binding: ListItemMealsBinding

    class CategoryViewHolder(private val binding: ListItemMealsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(categoryMeal: CategoryMeal) {
            binding.mealNameTextview.text = categoryMeal.strMeal
            binding.mealThumb.load(categoryMeal.strMealThumb) {
                crossfade(true)
                placeholder(R.drawable.ic_launcher_background)
                transformations(CircleCropTransformation())
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        binding = ListItemMealsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return meals.meals.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(meals.meals[position])
    }

}
