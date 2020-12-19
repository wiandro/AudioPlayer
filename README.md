# AudioPlayer

A Simple Audio Player Android Application to play (online/offline) songs by running a service in the background
and displaying a notification at top of the screen.



### The App Scenario:

After selecting songs from your device, they will be saved in database and will be displayed in a playlist. Besides when a list item
is clicked, the song player page is displayed whereas player service is run in the background
and notification will be displayed at top of the screen.(Clicking on notification has been handled!)
Also if you click long on the song item of playlist, it will be removed both from your stored and displayed playlist.



### Technologies & Methodologies which used:

- Koin
- Clean Architecture
- MVVM Pattern
- LiveData
- Coil(Image Loader)
- ExoPlayer
- Mockito



### The features of player module:

- The player service run in the background and can`t be killed until user stops a song.
- The notification of playing song will be diplayed at top of screen. (both collapse/Expand views were supported)
- Player actions in use consists of play/pause, skip to next/previous, repeat one song, repeat all songs,
shuffle songs,...
- Supported swiping to left/right side.



### Supported Android Versions:

- Android 4.0.3 Ice Cream Sandwich(API level 16) or higher

