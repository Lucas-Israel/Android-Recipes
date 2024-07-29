package br.com.lucasIsrael.androidrecipes.meals.recipe.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import br.com.lucasIsrael.androidrecipes.R
import br.com.lucasIsrael.androidrecipes.databinding.RecipeFragmentBinding
import br.com.lucasIsrael.androidrecipes.meals.recipe.ui.viewmodels.RecipeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeFragment: Fragment() {

    private lateinit var binding: RecipeFragmentBinding
    private val viewModel: RecipeViewModel by viewModels()
    private val args: RecipeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.recipe_fragment, container, false)
        binding = RecipeFragmentBinding.bind(view)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val recipeId = args.recipeId
        viewModel.getRecipe(recipeId)
    }
}