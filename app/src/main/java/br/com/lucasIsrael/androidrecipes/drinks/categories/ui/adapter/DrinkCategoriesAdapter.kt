package br.com.lucasIsrael.androidrecipes.drinks.categories.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.lucasIsrael.androidrecipes.databinding.ListItemDrinkCategoriesBinding
import br.com.lucasIsrael.androidrecipes.drinks.categories.data.model.DrinkCategory

class DrinkCategoriesAdapter(private val drinkCategories: List<DrinkCategory>) :
    RecyclerView.Adapter<DrinkCategoriesAdapter.DrinkCategoriesViewHolder>() {

    private lateinit var binding: ListItemDrinkCategoriesBinding

    class DrinkCategoriesViewHolder(private val binding: ListItemDrinkCategoriesBinding) :
        ViewHolder(binding.root) {
        fun bind(category: DrinkCategory) {
            binding.drinkNameData.text = category.strCategory
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkCategoriesViewHolder {
        binding = ListItemDrinkCategoriesBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return DrinkCategoriesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return drinkCategories.size
    }

    override fun onBindViewHolder(holder: DrinkCategoriesViewHolder, position: Int) {
        val item = drinkCategories[position]

        holder.bind(item)
    }

}
