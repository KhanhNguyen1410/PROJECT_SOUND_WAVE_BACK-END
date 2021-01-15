package com.sound.wave.controller.song;

import com.sound.wave.model.Song;
import com.sound.wave.service.song.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.Socket;
import java.util.Optional;

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
    public ResponseEntity<Song> saveNewSong(@Valid @RequestBody Song song, BindingResult bindingResult){
        if (!bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(iSongService.save(song), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Song> deleteSong(@PathVariable("id") Long id){
        Optional<Song> song = iSongService.findById(id);
        if (song.get() == null){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        iSongService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable("id") Long id, @RequestBody Song song ){
        Optional<Song> currentSong = iSongService.findById(id);
        if (currentSong == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentSong.get().setName(song.getName());
        currentSong.get().setDescription(song.getDescription());
        currentSong.get().setAvatar(song.getAvatar());
        currentSong.get().setMusician(song.getMusician());
        currentSong.get().setSinger(song.getSinger());
        currentSong.get().setUser(song.getUser());
        currentSong.get().setCategory(song.getCategory());
        currentSong.get().setAlbum(song.getAlbum());

        iSongService.save(currentSong.get());
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
