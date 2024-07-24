package br.com.lucasIsrael.androidrecipes.meals.categories.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.lucasIsrael.androidrecipes.R
import br.com.lucasIsrael.androidrecipes.databinding.ListItemCategoriesBinding
import br.com.lucasIsrael.androidrecipes.meals.categories.data.model.Category
import coil.load
import coil.transform.CircleCropTransformation

class CategoriesAdapter(private val categories: List<Category>) :
    RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    private lateinit var binding: ListItemCategoriesBinding

    class CategoriesViewHolder(private val binding: ListItemCategoriesBinding) :
        ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.categoryNameTextview.text = category.strCategory
            binding.categoryDescriptionTextview.text = category.strCategoryDescription
            binding.categoryThumb.load(category.strCategoryThumb)  {
                crossfade(true)
                placeholder(R.drawable.ic_launcher_background)
                transformations(CircleCropTransformation())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        binding =
            ListItemCategoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(categories[position])
    }
}
