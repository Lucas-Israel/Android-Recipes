package br.com.lucasIsrael.androidrecipes.meals.recipe.ui.fragment

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
import br.com.lucasIsrael.androidrecipes.databinding.RecipeFragmentBinding
import br.com.lucasIsrael.androidrecipes.meals.recipe.ui.adapter.RecipeAdapter
import br.com.lucasIsrael.androidrecipes.meals.recipe.ui.viewmodel.RecipeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecipeFragment : Fragment() {

    private val viewModel: RecipeViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private val args: RecipeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.recipe_fragment, container, false)
        val binding = RecipeFragmentBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recipe_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onStart() {
        super.onStart()
        val recipeId = args.recipeId
        viewModel.getRecipe(recipeId)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.recipe.collect {
                recyclerView.adapter = RecipeAdapter(it)
            }
        }
    }
}
