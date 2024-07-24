package br.com.lucasIsrael.androidrecipes.meals.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.lucasIsrael.androidrecipes.R
import br.com.lucasIsrael.androidrecipes.databinding.ListItemCategoryBinding
import br.com.lucasIsrael.androidrecipes.meals.data.model.Category
import coil.load
import coil.transform.CircleCropTransformation

class CategoriesAdapter(private val categories: List<Category>) :
    RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    private lateinit var binding: ListItemCategoryBinding

    class CategoriesViewHolder(private val binding: ListItemCategoryBinding) :
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
            ListItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(categories[position])
    }
}
