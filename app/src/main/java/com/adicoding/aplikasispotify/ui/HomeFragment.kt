package com.adicoding.aplikasispotify.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.adicoding.aplikasispotify.R

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val navController by lazy { findNavController() }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val adapter = TrackAdapter { track ->
//            val action = HomeFragmentDirections.actionHomeToDetail(track.id)
//            navController.navigate(action)
//        }
//
//        // Setup RecyclerView with adapter
//    }
}