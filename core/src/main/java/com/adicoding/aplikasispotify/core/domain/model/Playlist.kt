package com.adicoding.aplikasispotify.core.domain.model

import com.adicoding.aplikasispotify.core.data.source.remote.response.Track

data class Playlist(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String,
    val tracks: List<Track>
)