package com.adicoding.aplikasispotify.ui.myplaylists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.adicoding.aplikasispotify.core.domain.repository.ITrackRepository

class MyPlaylistsViewModel(private val repository: ITrackRepository) : ViewModel() {

    // Function to get playlists using a token
    fun getMyPlaylists(token: String) = repository.getMyPlaylists(token).asLiveData()
}
