package com.wiandro.audioplayer.media

import android.util.Log
import com.wiandro.audioplayer.exo.OnExoPlayerManagerCallback
import com.wiandro.audioplayer.model.ASong
import com.wiandro.audioplayer.playlist.PlaylistManager
import java.util.*


/**
 * This class is used to interact with [ExoPlayerManager] & [PlaylistManager]
 *
 * @author ZARA
 * */
class MediaAdapter(
    private val onExoPlayerManagerCallback: OnExoPlayerManagerCallback,
    private val mediaAdapterCallback: OnMediaAdapterCallback
) : OnExoPlayerManagerCallback.OnSongStateCallback, PlaylistManager.OnSongUpdateListener {

    private var playlistManager: PlaylistManager? = null

    init {
        onExoPlayerManagerCallback.setCallback(this)
        playlistManager = PlaylistManager(this)
    }

    override fun play(song: ASong) {
        onExoPlayerManagerCallback.play(song)
    }

    fun play(songList: MutableList<ASong>, song: ASong) {
        playlistManager?.setCurrentPlaylist(songList, song)
    }

    fun pause() {
        onExoPlayerManagerCallback.pause()
    }

    fun seekTo(position: Long) {
        onExoPlayerManagerCallback.seekTo(position)
    }

    fun stop() {
        onExoPlayerManagerCallback.stop()
    }

    fun skipToNext() {
        playlistManager?.skipPosition(1)
    }

    fun skipToPrevious() {
        playlistManager?.skipPosition(-1)
    }

    fun addToCurrentPlaylist(songList: ArrayList<ASong>) {
        Log.d(TAG, "addToCurrentPlaylist() called with: songList = $songList")
        playlistManager?.addToPlaylist(songList)
    }

    fun addToCurrentPlaylist(song: ASong) {
        Log.d(TAG, "addToCurrentPlaylist() called with: song = $song")
        playlistManager?.addToPlaylist(song)
    }

    override fun shuffle(isShuffle: Boolean) {
        playlistManager?.setShuffle(isShuffle)
    }

    override fun repeatAll(isRepeatAll: Boolean) {
        playlistManager?.setRepeatAll(isRepeatAll)
    }

    override fun repeat(isRepeat: Boolean) {
        playlistManager?.setRepeat(isRepeat)
    }


    override fun onSongChanged(song: ASong) {
        mediaAdapterCallback.onSongChanged(song)
    }

    override fun onSongRetrieveError() {
        //Log.d(TAG, "onSongRetrieveError() called")
    }

    override fun onPlaybackStatusChanged(state: Int) {
        mediaAdapterCallback.onPlaybackStateChanged(state)
    }

    override fun getCurrentSongList(): ArrayList<ASong>?{
        return playlistManager?.getCurrentSongList()
    }

    override fun getCurrentSong(): ASong? {
        return playlistManager?.getCurrentSong()
    }

    override fun setCurrentPosition(position: Long, duration: Long) {
        mediaAdapterCallback.setDuration(duration, position)
    }


    override fun onCompletion() {
        if (playlistManager?.isRepeat() == true) {
            onExoPlayerManagerCallback.stop()
            playlistManager?.repeat()
            return
        }

        if (playlistManager?.hasNext() == true) {
            playlistManager?.skipPosition(1)
            return
        }

        if (playlistManager?.isRepeatAll() == true) {
            playlistManager?.skipPosition(-1)
            return
        }

        onExoPlayerManagerCallback.stop()
    }


    companion object {
        private val TAG = MediaAdapter::class.java.name
    }

}