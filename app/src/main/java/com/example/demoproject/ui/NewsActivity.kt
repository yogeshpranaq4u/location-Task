package com.example.demoproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.demoproject.R
import com.example.demoproject.databinding.NewsActivityBinding

class NewsActivity : AppCompatActivity() {
    private var binding: NewsActivityBinding? = null
    private var navControllers: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = NewsActivityBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        navControllers = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(R.id.startFragment),
            fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )
        findViewById<Toolbar>(R.id.newsToolbar)
            .setupWithNavController(navControllers!!, appBarConfiguration)
        showToolbar()
    }

    private fun showToolbar() {
        navControllers?.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.homeFragment) {
                supportActionBar?.show()
            } else if (destination.id == R.id.newsViewFragment) {
                supportActionBar?.show()
            } else if (destination.id == R.id.businessNewsFragment) {
                supportActionBar?.show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navControllers?.navigateUp() == true || super.onSupportNavigateUp()
    }

}