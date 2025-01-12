package com.adicoding.aplikasispotify.core.domain.repository

import com.adicoding.aplikasispotify.core.domain.model.Playlist
import kotlinx.coroutines.flow.Flow

interface ITrackRepository {
    suspend fun getPlaylists(token: String, playlistId: String): List<Playlist>
    fun getMyPlaylists(token: String): Flow<List<Playlist>>
}
