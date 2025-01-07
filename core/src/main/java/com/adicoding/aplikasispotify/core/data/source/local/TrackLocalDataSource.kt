package com.adicoding.aplikasispotify.core.data.source.local

import com.adicoding.aplikasispotify.core.data.source.local.entity.TrackEntity
import com.adicoding.aplikasispotify.core.data.source.local.room.TrackDao
import com.adicoding.aplikasispotify.core.domain.model.Track
import kotlinx.coroutines.flow.Flow


class TrackLocalDataSource(private val trackDao: TrackDao) {

    fun getFavoriteTracks(): Flow<List<TrackEntity>> {
        return trackDao.getFavoriteTracks()
    }

    suspend fun insertTrack(track: TrackEntity) {
        trackDao.insertTrack(track)
    }

    suspend fun deleteTrack(track: TrackEntity) {
        trackDao.deleteTrack(track)
    }
}

