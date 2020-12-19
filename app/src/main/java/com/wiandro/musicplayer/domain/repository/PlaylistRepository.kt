package com.wiandro.musicplayer.domain.repository

import com.wiandro.musicplayer.data.model.Song

interface PlaylistRepository {

    fun saveSongData(song: Song):Long

    fun getSongs(): List<Song>?

    fun delete(song: Song)

}