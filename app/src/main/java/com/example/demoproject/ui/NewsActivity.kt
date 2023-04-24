package com.example.demoproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.demoproject.R
import com.example.demoproject.databinding.NewsActivityBinding

class NewsActivity:AppCompatActivity() {
    private var binding: NewsActivityBinding? = null
    private var navControllers: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NewsActivityBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
      navControllers = navHostFragment.navController
    }

    override fun onSupportNavigateUp(): Boolean {
        return navControllers?.navigateUp() == true || super.onSupportNavigateUp()
    }

}