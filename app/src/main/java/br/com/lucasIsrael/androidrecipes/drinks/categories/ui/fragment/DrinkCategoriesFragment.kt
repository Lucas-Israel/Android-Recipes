package br.com.lucasIsrael.androidrecipes.drinks.categories.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.lucasIsrael.androidrecipes.R
import br.com.lucasIsrael.androidrecipes.databinding.FragmentCategoriesBinding
import br.com.lucasIsrael.androidrecipes.drinks.categories.ui.adapter.DrinkCategoriesAdapter
import br.com.lucasIsrael.androidrecipes.drinks.categories.ui.viewmodel.DrinkCategoriesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DrinkCategoriesFragment : Fragment() {

    private val viewModel: DrinkCategoriesViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_categories, container, false)
        val binding = FragmentCategoriesBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.categories_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onStart() {
        super.onStart()
        viewModel.getCategories()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.drinkCategories.collect {
                recyclerView.adapter = DrinkCategoriesAdapter(it.drinks.toList())
            }
        }
    }
}
