package com.adicoding.aplikasispotify.core.data.source.remote

import com.adicoding.aplikasispotify.core.data.source.remote.network.ApiService
import com.adicoding.aplikasispotify.core.data.source.remote.response.PlaylistResponse
import com.adicoding.aplikasispotify.core.data.source.remote.response.TrackResponse

class TrackRemoteDataSource(private val apiService: ApiService) {
    suspend fun getTracks(token: String): List<TrackResponse> {
        return apiService.getSavedTracks("Bearer $token")
    }

    suspend fun getPlaylists(token: String, playlistId: String): PlaylistResponse {
        return apiService.getPlaylists("Bearer $token", playlistId)
    }
}