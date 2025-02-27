package com.adicoding.aplikasispotify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.adicoding.aplikasispotify.databinding.ActivityMainBinding
import com.adicoding.aplikasispotify.ui.myplaylists.MyPlaylistsFragment
import com.adicoding.aplikasispotify.ui.PlaylistFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set default fragment
//        loadFragment(PlaylistFragment())
        loadFragment(MyPlaylistsFragment())

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    loadFragment(MyPlaylistsFragment())
                    true
                }
                R.id.nav_playlists -> {
                    loadFragment(MyPlaylistsFragment())
                    true
                }
//                R.id.nav_profile -> {
//                    loadFragment(ProfileFragment())
//                    true
//                }
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