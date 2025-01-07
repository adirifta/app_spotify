package com.adicoding.aplikasispotify.core.data.source.remote.response

import com.adicoding.aplikasispotify.core.domain.model.Track

data class TrackResponse(
    val id: String,
    val name: String,
    val artist: String,
    val imageUrl: String
) {
    fun toDomain(): Track {
        return Track(id, name, artist, imageUrl)
    }
}