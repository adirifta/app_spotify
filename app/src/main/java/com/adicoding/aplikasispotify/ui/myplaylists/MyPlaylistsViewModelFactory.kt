package com.adicoding.aplikasispotify.ui.myplaylists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adicoding.aplikasispotify.core.domain.repository.ITrackRepository

class MyPlaylistsViewModelFactory(private val repository: ITrackRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyPlaylistsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MyPlaylistsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}