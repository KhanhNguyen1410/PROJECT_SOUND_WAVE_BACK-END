package com.sound.wave.controller.songPlaylist;

import com.sound.wave.model.PlayList;
import com.sound.wave.model.Song;
import com.sound.wave.model.SongPlaylist;
import com.sound.wave.service.playlist.IPlaylistService;
import com.sound.wave.service.song.ISongService;
import com.sound.wave.service.songPlaylist.ISongPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/playlist/{id}")
    public ResponseEntity<Iterable<SongPlaylist>> getAllSongPlaylistByPlaylistId(@PathVariable("id") Long id){
        Iterable<SongPlaylist> playlists = songPlaylistService.findSongsByPlaylistId(id);
        if (playlists == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongPlaylist> getSongPlaylistById(@PathVariable("id") Long id){
        SongPlaylist songPlaylist= songPlaylistService.findById(id).get();
        if (songPlaylist == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(songPlaylist, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<Iterable<SongPlaylist>> getAllSongPlaylist(){
        Iterable<SongPlaylist> playlists = songPlaylistService.findAll();
        if (playlists == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @GetMapping("/songs/{id}")
    public ResponseEntity<Iterable<Song>> getSongByPlaylistId(@PathVariable("id")Long id){
        Iterable<Song> songs = songService.findSongsByPlaylistId(id);
        if (songs == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
    @PostMapping("/{id}")
    public ResponseEntity<SongPlaylist> addSongIntoPlaylist(@PathVariable("id") Long id,@Valid  @RequestBody Song song, BindingResult bindingResult){
       if (song == null){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       Iterable<Song> songs = songService.findSongsByPlaylistId(id);
       for(Song song1: songs){
           if (song1.getId() == song.getId() ){
               return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
       }
       }
        PlayList playList = playlistService.findPlaylistById(id);
       SongPlaylist songPlaylist =  new SongPlaylist();
       songPlaylist.setPlayList(playList);
       songPlaylist.setSong(song);
        return new ResponseEntity<>(songPlaylistService.save(songPlaylist), HttpStatus.OK);
    }
    @PostMapping("/check-song/{id}")
    public ResponseEntity<Boolean> checkSongInPlaylist(@PathVariable("id") Long id, @RequestBody Song song){
        Iterable<Song> songs = songService.findSongsByPlaylistId(id);
        for (Song song1: songs){
            if (song.getId() == song1.getId()){
                return new ResponseEntity<>(false,HttpStatus.CONFLICT);
            }
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    
}
