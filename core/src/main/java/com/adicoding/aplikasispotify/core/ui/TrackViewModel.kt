package com.adicoding.aplikasispotify.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.adicoding.aplikasispotify.core.domain.repository.ITrackRepository
import kotlinx.coroutines.Dispatchers

class TrackViewModel(private val repository: ITrackRepository) : ViewModel() {
//    fun getTracks(token: String) = repository.getTracks(token).asLiveData(Dispatchers.IO)
    fun getFavoriteTracks() = repository.getFavoriteTracks().asLiveData(Dispatchers.IO)
    fun getPlaylists(token: String) = liveData(Dispatchers.IO) {
        emit(repository.getPlaylists(token))
    }
}