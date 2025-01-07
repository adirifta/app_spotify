package com.adicoding.aplikasispotify.core.data.source.remote.network

import com.adicoding.aplikasispotify.core.data.source.remote.response.PlaylistResponse
import com.adicoding.aplikasispotify.core.data.source.remote.response.TrackResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {
    @GET("v1/me/tracks")
    suspend fun getSavedTracks(@Header("Authorization") token: String): List<TrackResponse>

    @GET("playlist")
    suspend fun getPlaylists(@Header("Authorization") token: String): List<PlaylistResponse>
}