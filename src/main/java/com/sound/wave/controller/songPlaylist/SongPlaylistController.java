package com.sound.wave.controller.songPlaylist;

import com.sound.wave.model.Song;
import com.sound.wave.model.SongPlaylist;
import com.sound.wave.service.playlist.IPlaylistService;
import com.sound.wave.service.song.ISongService;
import com.sound.wave.service.songPlaylist.ISongPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
@CrossOrigin("*")
@RequestMapping("/song-playlists")
public class SongPlaylistController {
    @Autowired
    private ISongPlaylistService songPlaylistService;

    @Autowired
    private ISongService songService;

    @Autowired
    private IPlaylistService playlistService;

    @GetMapping("/{id}")
    public ResponseEntity<Iterable<SongPlaylist>> getAllSongsByPlaylistId(@PathVariable("id") Long id){
        Iterable<SongPlaylist> playlists = songPlaylistService.findSongsByPlaylistId(id);
        if (playlists == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

//    @GetMapping("/songs/{id}")
//    public ResponseEntity<Iterable<Song>> getSongByPlaylistId(@PathVariable("id")Long id){
//        Iterable<Song> songs = songService.
//    }
}
