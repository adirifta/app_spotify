package com.adicoding.aplikasispotify.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.adicoding.aplikasispotify.core.domain.repository.ITrackRepository
import kotlinx.coroutines.Dispatchers

class TrackViewModel(private val repository: ITrackRepository) : ViewModel() {

    fun getPlaylists(token: String, playlistId: String) = liveData(Dispatchers.IO) {
        emit(repository.getPlaylists(token, playlistId))
    }
}
