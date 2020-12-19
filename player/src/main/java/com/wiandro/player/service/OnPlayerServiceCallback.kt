package com.wiandro.player.service

import com.wiandro.player.model.ASong

/**
 * To make an interaction between [SongPlayerService] & [BaseSongPlayerActivity]
 *
 * @author ZARA
 * */
interface OnPlayerServiceCallback {

    fun updateSongData(song: ASong)

    fun updateSongProgress(duration: Long, position: Long)

    fun setBufferingData(isBuffering: Boolean)

    fun setVisibilityData(isVisibility: Boolean)

    fun setPlayStatus(isPlay: Boolean)

    fun stopService()
}