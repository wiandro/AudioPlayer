package com.wiandro.musicplayer.domain.usecase

import com.wiandro.musicplayer.data.model.Song
import com.wiandro.musicplayer.domain.repository.PlaylistRepository

class DeleteSongUseCase(private val playlistRepository: PlaylistRepository) {


    fun deleteSongItem(song: Song) {
        playlistRepository.delete(song)
    }
}