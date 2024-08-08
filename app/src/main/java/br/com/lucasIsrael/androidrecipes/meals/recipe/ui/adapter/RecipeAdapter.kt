package br.com.lucasIsrael.androidrecipes.meals.recipe.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.lucasIsrael.androidrecipes.R
import br.com.lucasIsrael.androidrecipes.databinding.ListItemRecipeBinding
import br.com.lucasIsrael.androidrecipes.meals.recipe.data.model.Meals
import br.com.lucasIsrael.androidrecipes.meals.recipe.data.model.Recipe
import coil.load

class RecipeAdapter(private val recipe: Meals) :
    RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    private lateinit var binding: ListItemRecipeBinding

    class RecipeViewHolder(private val binding: ListItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: Recipe) {
            binding.recipeImageview.load(recipe.strMealThumb) {
                crossfade(true)
                placeholder(R.drawable.ic_launcher_background)
            }
            binding.recipeTextviewName.text = recipe.strMeal
            binding.recipeCategoryNameData.text = recipe.strCategory
            binding.recipeAreaNameData.text = recipe.strArea
            binding.recipeTagsData.text = recipe.strTags
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        binding = ListItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return recipe.meals.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(recipe.meals[position])
    }
}
