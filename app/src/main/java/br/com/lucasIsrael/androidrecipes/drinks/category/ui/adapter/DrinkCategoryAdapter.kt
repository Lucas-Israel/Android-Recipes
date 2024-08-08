package br.com.lucasIsrael.androidrecipes.drinks.category.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.lucasIsrael.androidrecipes.R
import br.com.lucasIsrael.androidrecipes.databinding.ListItemMealsBinding
import br.com.lucasIsrael.androidrecipes.drinks.category.data.model.DrinkRecipe
import br.com.lucasIsrael.androidrecipes.drinks.category.data.model.DrinksCategory
import coil.load
import coil.transform.CircleCropTransformation

class DrinkCategoryAdapter(private val drinks: DrinksCategory) :
    RecyclerView.Adapter<DrinkCategoryAdapter.DrinkCategoryViewHolder>() {

    lateinit var binding: ListItemMealsBinding

    class DrinkCategoryViewHolder(private val binding: ListItemMealsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(drinkCategory: DrinkRecipe) {
            binding.mealNameTextview.text = drinkCategory.strDrink
            binding.mealThumb.load(drinkCategory.strDrinkThumb) {
                crossfade(true)
                placeholder(R.drawable.ic_launcher_background)
                transformations(CircleCropTransformation())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkCategoryViewHolder {
        binding = ListItemMealsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DrinkCategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return drinks.drinks.size
    }

    override fun onBindViewHolder(holder: DrinkCategoryViewHolder, position: Int) {
        val item = drinks.drinks[position]

        holder.bind(item)
    }
}
