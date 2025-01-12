package com.adicoding.aplikasispotify.favorite.ui

import androidx.lifecycle.ViewModel
import com.adicoding.aplikasispotify.core.domain.model.Track
import com.adicoding.aplikasispotify.core.domain.repository.ITrackRepository
import kotlinx.coroutines.flow.Flow

class FavoriteViewModel(private val repository: ITrackRepository) : ViewModel() {
//    val favoriteTracks: Flow<List<Track>> = repository.getFavoriteTracks()
}