package com.adicoding.aplikasispotify.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.adicoding.aplikasispotify.core.domain.repository.ITrackRepository
import com.adicoding.aplikasispotify.core.ui.PlaylistAdapter
import com.adicoding.aplikasispotify.core.ui.TrackViewModel
import com.adicoding.aplikasispotify.databinding.FragmentPlaylistBinding
import org.koin.android.ext.android.inject

class PlaylistFragment : Fragment() {

    private var _binding: FragmentPlaylistBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: TrackViewModel
    private lateinit var playlistAdapter: PlaylistAdapter

    private val repository: ITrackRepository by inject()

    companion object {
        private const val ARG_PLAYLIST_ID = "playlist_id"
        private const val ARG_PLAYLIST_NAME = "playlist_name"

        fun newInstance(playlistId: String, playlistName: String): PlaylistFragment {
            val fragment = PlaylistFragment()
            val args = Bundle()
            args.putString(ARG_PLAYLIST_ID, playlistId)
            args.putString(ARG_PLAYLIST_NAME, playlistName)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlaylistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val playlistId = arguments?.getString(ARG_PLAYLIST_ID) ?: return
        val playlistName = arguments?.getString(ARG_PLAYLIST_NAME) ?: ""

        binding.tvPlaylistName.text = playlistName

        playlistAdapter = PlaylistAdapter()
        binding.rvTracks.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = playlistAdapter
        }

        val factory = TrackViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[TrackViewModel::class.java]

        val token = "vpCCQHTwyJHoYyuN"
        viewModel.getPlaylists(token, playlistId).observe(viewLifecycleOwner) { playlists ->
            if (playlists.isNotEmpty()) {
                // Mendapatkan daftar tracks yang ada pada playlist
                val tracks = playlists.flatMap { it.tracks.orEmpty() } // Pastikan tracks ada dalam model Playlist
                playlistAdapter.submitList(tracks)
            } else {
                Toast.makeText(context, "Failed to load tracks", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


