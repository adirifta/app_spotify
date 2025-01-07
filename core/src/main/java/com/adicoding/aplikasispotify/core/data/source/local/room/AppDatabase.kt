package com.adicoding.aplikasispotify.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adicoding.aplikasispotify.core.data.source.local.entity.TrackEntity

@Database(entities = [TrackEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun trackDao(): TrackDao
}
