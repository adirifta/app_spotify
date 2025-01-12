package com.adicoding.aplikasispotify.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adicoding.aplikasispotify.core.domain.repository.ITrackRepository
import com.adicoding.aplikasispotify.core.ui.TrackViewModel

class TrackViewModelFactory(private val repository: ITrackRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TrackViewModel::class.java)) {
            return TrackViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
