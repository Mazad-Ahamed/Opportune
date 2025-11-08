package com.example.opportune

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.opportune.UI_Design.AddjobsFragment
import com.example.opportune.UI_Design.BookmarkFragment
import com.example.opportune.UI_Design.HomeFragment
import com.example.opportune.UI_Design.ProfileFragment
import com.example.opportune.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomnavber.setOnItemSelectedListener {item ->
            when (item.itemId) {
                R.id.nav_home -> replaceFragment(HomeFragment())
                R.id.nav_add -> replaceFragment(AddjobsFragment())
                R.id.nav_saved -> replaceFragment(BookmarkFragment())
                R.id.nav_profile -> replaceFragment(ProfileFragment())

            }
            true
        }

        }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainActivity, fragment)
            .commit()
    }
    }

