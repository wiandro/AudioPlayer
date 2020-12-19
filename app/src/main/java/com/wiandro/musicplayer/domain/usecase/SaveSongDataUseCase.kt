package com.wiandro.musicplayer.domain.usecase

import com.wiandro.musicplayer.data.model.Song
import com.wiandro.musicplayer.domain.repository.PlaylistRepository

class SaveSongDataUseCase(private val playlistRepository: PlaylistRepository) {

    fun saveSongItem(song: Song) {
        playlistRepository.saveSongData(song)
    }
}