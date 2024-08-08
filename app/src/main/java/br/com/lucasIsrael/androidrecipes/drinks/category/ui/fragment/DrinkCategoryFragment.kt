package br.com.lucasIsrael.androidrecipes.drinks.category.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.lucasIsrael.androidrecipes.R
import br.com.lucasIsrael.androidrecipes.databinding.FragmentCategoryBinding
import br.com.lucasIsrael.androidrecipes.drinks.category.ui.adapter.DrinkCategoryAdapter
import br.com.lucasIsrael.androidrecipes.drinks.category.ui.viewmodel.DrinkCategoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DrinkCategoryFragment : Fragment() {

    private val viewModel: DrinkCategoryViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private val args: DrinkCategoryFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_category, container, false)
        val binding = FragmentCategoryBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.meals_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onStart() {
        super.onStart()
        val placeHolderName = args.categoryName
        viewModel.getCategory(placeHolderName)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.drinkCategory.collect {
                recyclerView.adapter = DrinkCategoryAdapter(it)
            }
        }
    }
}
