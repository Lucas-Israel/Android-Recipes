package br.com.lucasIsrael.androidrecipes.common.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import br.com.lucasIsrael.androidrecipes.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bottomNavigationImpl()

    }

    /**
     * Sets up navigation between Meals fragment and Drinks fragment.
     */
    private fun bottomNavigationImpl() {
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        navView.setupWithNavController(navController)

        navView.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.bottom_navigation_meals -> {
                    navController.navigate(R.id.categoriesFragment)
                    true
                }

                R.id.bottom_navigation_drinks -> {
                    navController.navigate(R.id.drinkCategoriesFragment)
                    true
                }

                else -> false
            }
        }
    }
}
