package com.adicoding.aplikasispotify.ui.myplaylists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.adicoding.aplikasispotify.R
import com.adicoding.aplikasispotify.core.domain.repository.ITrackRepository
import com.adicoding.aplikasispotify.core.ui.MyPlaylistsAdapter
import com.adicoding.aplikasispotify.databinding.FragmentPlaylistBinding
import com.adicoding.aplikasispotify.ui.PlaylistFragment
import org.koin.android.ext.android.inject

class MyPlaylistsFragment : Fragment() {
    private var _binding: FragmentPlaylistBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MyPlaylistsViewModel
    private lateinit var myPlaylistsAdapter: MyPlaylistsAdapter

    // Inject repository (sesuaikan dengan metode DI Anda)
    private val repository: ITrackRepository by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlaylistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup ViewModel with Factory
        val factory = MyPlaylistsViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[MyPlaylistsViewModel::class.java]

        // Setup RecyclerView
        myPlaylistsAdapter = MyPlaylistsAdapter { playlist ->
            val playlistFragment = PlaylistFragment.newInstance(playlist.id, playlist.name)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, playlistFragment) // Ganti container ID dengan yang sesuai
                .addToBackStack(null)
                .commit()
        }

        binding.rvTracks.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = myPlaylistsAdapter
        }

        val token = "vpCCQHTwyJHoYyuN"
        viewModel.getMyPlaylists(token).observe(viewLifecycleOwner) { playlists ->
            if (playlists.isNotEmpty()) {
                myPlaylistsAdapter.submitList(playlists)
            } else {
                Toast.makeText(context, "No playlists found", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
