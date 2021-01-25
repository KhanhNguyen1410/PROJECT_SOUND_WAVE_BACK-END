package com.sound.wave.controller.song;

import com.sound.wave.model.Category;
import com.sound.wave.model.Song;
import com.sound.wave.service.category.ICategoryService;
import com.sound.wave.service.song.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.bind.SchemaOutputResolver;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private ISongService iSongService;
    @Autowired
    private ICategoryService iCategoryService;
    // lay all song
    @GetMapping()
    public ResponseEntity<Iterable<Song>> findAllSong(){
        return new ResponseEntity<>(iSongService.findAll(), HttpStatus.OK);
    }
    // lay song bang
    @PostMapping("/getsong")
    public ResponseEntity<Song> getSongbyId(@RequestBody Long id) {
        Song song = iSongService.findSongById(id);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Song> saveNewSong(@Valid @RequestBody Song song, BindingResult bindingResult){
        if (!bindingResult.hasFieldErrors()) {
            song.setDateCreate(LocalDateTime.now());
            return new ResponseEntity<>(iSongService.save(song), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Song> findSongById(@PathVariable("id") Long id){
        Song songOptional = iSongService.findById(id).get();
        if (songOptional == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(songOptional,HttpStatus.OK);
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
    public ResponseEntity<Song> updateSong(@Valid @PathVariable("id") Long id, @RequestBody Song song, BindingResult bindingResult ){
        Optional<Song> currentSong = iSongService.findById(id);
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        if (currentSong == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentSong.get().setName(song.getName());
        currentSong.get().setDescription(song.getDescription());
        currentSong.get().setAvatar(song.getAvatar());
        currentSong.get().setUrlMp3(song.getUrlMp3());
        currentSong.get().setMusician(song.getMusician());
        currentSong.get().setSinger(song.getSinger());
        currentSong.get().setUser(song.getUser());
        currentSong.get().setCategory(song.getCategory());
        currentSong.get().setAlbum(song.getAlbum());
        currentSong.get().setDateCreate(LocalDateTime.now());
        iSongService.save(currentSong.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/my-songs")
    public ResponseEntity<Iterable<Song>> findSongByUser(@RequestBody long user_id){
        return new ResponseEntity<>(iSongService.findAllByUserId(user_id), HttpStatus.OK);
    }
    @PostMapping("/count-views")
    public ResponseEntity<Song> countViews(@RequestBody long id){
      return new ResponseEntity<>( iSongService.updateViews(id),HttpStatus.OK);
    }

    @GetMapping("/most-views")
    public ResponseEntity<Iterable<Song>> findSongsByMostViews(){
        Iterable<Song> songs = iSongService.findSongsByMostViews();
        if (songs == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
    @GetMapping("/new-date")
    public ResponseEntity<Iterable<Song>> findSongByDateNew(){
        Iterable<Song> songs = iSongService.findSongsByDateNew();
        if (songs == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
    @GetMapping("/most-likes")
    public ResponseEntity<Iterable<Song>> findSongByMostLike(){
        Iterable<Song> songIterable = iSongService.findSongsByMostLike();
        if (songIterable == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(songIterable, HttpStatus.OK);
    }

    @PostMapping("/search/{name}")
    public ResponseEntity<Iterable<Song>> searchByName(@PathVariable String name ){
        Iterable<Song> songs = iSongService.findAllByNameContaining(name);
        return new ResponseEntity<>(songs,HttpStatus.OK);
    }
    @GetMapping("/date-new")
    public ResponseEntity<Iterable<Song>> findSongsByDateNew(){
        Iterable<Song> list = iSongService.findSongsByDateNew();
        if (list == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Iterable<Song>> getSongsByCategoryId(@PathVariable("id") Long id){
        Iterable<Song> songs = iSongService.findSongsByCategoryId(id);
        if (songs != null){
            return new ResponseEntity<>(songs, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all-like/{id}")
    public ResponseEntity<Iterable<Song>> getAllSongsByUserLike(@PathVariable("id") Long id){
        Iterable<Song> songs = iSongService.findAllSongsByUserIdLike(id);
        if (songs == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(songs,HttpStatus.OK);
    }

    @GetMapping("/sub/{id}")
    
    public ResponseEntity<Iterable<Song>> getSongsBySubId(@PathVariable("id")Long id){
        Iterable<Song> songs = iSongService.findSongsBySubId(id);
        if (songs == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
    @GetMapping("/have-not/{id}")
    public ResponseEntity<Iterable<Song>> getSongsHaveNotInPlaylist(@PathVariable("id")Long id){
        Iterable<Song> songs = iSongService.findSongsHaveNotInPlaylist(id);
        if (songs == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
}
