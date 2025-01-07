package com.adicoding.aplikasispotify.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adicoding.aplikasispotify.core.domain.model.Track

//class TrackAdapter(private val onItemClick: (String) -> Unit) : RecyclerView.Adapter<TrackAdapter.TrackViewHolder>() {
//    private var trackList = listOf<Track>()
//
//    fun setTracks(tracks: List<Track>) {
//        trackList = tracks
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
//        val binding = ItemTrackBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return TrackViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
//        val track = trackList[position]
//        holder.bind(track)
//    }
//
//    override fun getItemCount(): Int = trackList.size
//
//    inner class TrackViewHolder(private val binding: ItemTrackBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(track: Track) {
//            binding.track = track
//            binding.root.setOnClickListener { onItemClick(track.id) }
//        }
//    }
//}
