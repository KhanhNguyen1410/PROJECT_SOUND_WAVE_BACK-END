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
import java.time.LocalDate;
import java.util.List;
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
            song.setDate(LocalDate.now());
            return new ResponseEntity<>(iSongService.save(song), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Song> findSongById(@PathVariable("id") Long id){
        Song song = iSongService.findSongById(id);
        if (song == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Song>(song,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Song> deleteSong(@PathVariable("id") Long id){
        Song song = iSongService.findSongById(id);
        if (song == null){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        iSongService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Song> updateSong(@Valid @PathVariable("id") Long id, @RequestBody Song song, BindingResult bindingResult ){
        Song currentSong = iSongService.findSongById(id);
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        if (currentSong == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentSong.setName(song.getName());
        currentSong.setDescription(song.getDescription());
        currentSong.setAvatar(song.getAvatar());
        currentSong.setMusician(song.getMusician());
        currentSong.setSinger(song.getSinger());
        currentSong.setUser(song.getUser());
        currentSong.setCategory(song.getCategory());
        currentSong.setAlbum(song.getAlbum());
        currentSong.setDate(LocalDate.now());


        iSongService.save(currentSong);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Song>> searchSong(@RequestBody String name){
        Iterable<Song> songIterable = iSongService.findSongsByName(name);
        if (songIterable == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(songIterable, HttpStatus.OK);
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<List<Song>> findSongsByPlaylistId(@PathVariable("id") Long id){
        List<Song> list = iSongService.findSongsByPlaylistId(id);
        if (list == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/mostviews")
    public ResponseEntity<List<Song>> findSongByViewsLimit10(){
        List<Song> list = iSongService.findSongsByMostViews();
        if (list == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/datenew")
    public ResponseEntity<List<Song>> findSongsByDateNew(){
        List<Song> list = iSongService.findSongsByDateNew();
        if (list == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/search/user/{id}")
    public ResponseEntity<Iterable<Song>> findSongsByIdUser(@PathVariable("id") Long id){
        Iterable<Song> list = iSongService.findSongsByIdUser(id);
        if (list == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
