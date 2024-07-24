package br.com.lucasIsrael.androidrecipes.meals.category.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import br.com.lucasIsrael.androidrecipes.R
import br.com.lucasIsrael.androidrecipes.databinding.FragmentCategoryBinding
import br.com.lucasIsrael.androidrecipes.meals.category.ui.adapter.CategoryAdapter
import br.com.lucasIsrael.androidrecipes.meals.category.ui.viewmodels.CategoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    private val viewModel: CategoryViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_category, container, false)
        binding = FragmentCategoryBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.meals_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onStart() {
        super.onStart()
        //TODO this will be removed, its just a test for now
        viewModel.getCategory("Beef")
        viewModel.meals.observe(this) {
            recyclerView.adapter = CategoryAdapter(it)
        }
    }
}