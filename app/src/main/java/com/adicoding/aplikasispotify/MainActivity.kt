package com.adicoding.aplikasispotify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.adicoding.aplikasispotify.databinding.ActivityMainBinding
import com.adicoding.aplikasispotify.ui.PlaylistFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()

        // Set default fragment
        loadFragment(PlaylistFragment())
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_playlist -> {
                    loadFragment(PlaylistFragment())
                    true
                }
                // Tambahkan fragmen lain sesuai kebutuhan
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}