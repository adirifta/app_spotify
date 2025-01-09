package com.adicoding.aplikasispotify.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.adicoding.aplikasispotify.core.ui.PlaylistAdapter
import com.adicoding.aplikasispotify.core.ui.TrackViewModel
import com.adicoding.aplikasispotify.databinding.ActivityPlaylistBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class PlaylistActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlaylistBinding
    private val viewModel: TrackViewModel by viewModel()
    private val playlistAdapter = PlaylistAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaylistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        val token = "vpCCQHTwyJHoYyuN"
        val playlistId = "37i9dQZEVXbNG2KDcFcKOF"
        viewModel.getPlaylists(token, playlistId).observe(this) { playlists ->
            if (playlists != null) {
                playlistAdapter.submitList(playlists)
            } else {
                Toast.makeText(this, "Failed to load playlists", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupRecyclerView() {
        binding.rvPlaylists.apply {
            layoutManager = LinearLayoutManager(this@PlaylistActivity)
            adapter = playlistAdapter
        }
    }
}