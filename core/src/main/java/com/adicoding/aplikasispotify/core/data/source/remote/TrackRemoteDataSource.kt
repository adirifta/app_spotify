package com.adicoding.aplikasispotify.core.data.source.remote

import com.adicoding.aplikasispotify.core.data.source.remote.network.ApiService
import com.adicoding.aplikasispotify.core.data.source.remote.response.MyPlaylistsResponse
import com.adicoding.aplikasispotify.core.data.source.remote.response.PlaylistResponse

class TrackRemoteDataSource(private val apiService: ApiService) {

    suspend fun getPlaylists(token: String, playlistId: String): PlaylistResponse {
        return apiService.getPlaylists("Bearer $token", playlistId)
    }

    suspend fun getMyPlaylists(token: String): MyPlaylistsResponse {
        return apiService.getMyPlaylists("Bearer $token")
    }
}