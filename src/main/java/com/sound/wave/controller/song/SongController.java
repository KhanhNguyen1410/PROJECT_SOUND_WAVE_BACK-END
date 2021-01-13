package com.sound.wave.controller.song;

import com.sound.wave.model.Song;
import com.sound.wave.service.song.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private ISongService iSongService;

    @GetMapping()
    public ResponseEntity<Iterable<Song>> findAllSong(){
        return new ResponseEntity<>(iSongService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Song> saveNewSong(@RequestBody Song song){
        return new ResponseEntity<>(iSongService.save(song), HttpStatus.OK);
    }
}
