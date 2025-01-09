package com.adicoding.aplikasispotify.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.adicoding.aplikasispotify.core.ui.PlaylistAdapter
import com.adicoding.aplikasispotify.core.ui.TrackViewModel
import com.adicoding.aplikasispotify.databinding.FragmentPlaylistBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaylistFragment : Fragment() {

    private var _binding: FragmentPlaylistBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TrackViewModel by viewModel()
    private val playlistAdapter = PlaylistAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlaylistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        val token = "vpCCQHTwyJHoYyuN"
        val playlistId = "37i9dQZEVXbNG2KDcFcKOF"
        viewModel.getPlaylists(token, playlistId).observe(viewLifecycleOwner) { playlists ->
            if (playlists != null) {
                playlistAdapter.submitList(playlists)
            } else {
                Toast.makeText(requireContext(), "Failed to load playlists", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupRecyclerView() {
        binding.rvPlaylists.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = playlistAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}