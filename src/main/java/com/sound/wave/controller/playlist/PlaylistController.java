package com.sound.wave.controller.playlist;

import com.sound.wave.model.PlayList;
import com.sound.wave.service.playlist.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/playlists")
public class PlaylistController {
    @Autowired
    private IPlaylistService playlistService;

    @GetMapping()
    public ResponseEntity<Iterable<PlayList>> getAllPlaylist(){
        Iterable<PlayList> playLists = playlistService.findAll();
        if(playLists == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(playLists, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<PlayList> createPlaylist(@Valid @RequestBody PlayList playList, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(playlistService.save(playList),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PlayList> updatePlaylist(@PathVariable("id") Long id,@RequestBody PlayList playList, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        PlayList playListOptional= playlistService.findPlaylistById(id);
        if (playListOptional == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        playListOptional.setName(playList.getName());
        playListOptional.setCategory(playList.getCategory());
        playListOptional.setDescription(playList.getDescription());
        playListOptional.setDateCreate(playList.getDateCreate());
        playListOptional.setTimeUpdate(playList.getTimeUpdate());
        playlistService.save(playListOptional);
        return  new ResponseEntity<>(playListOptional, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<PlayList> deletePlaylist(@PathVariable("id") Long id){
        PlayList playList = playlistService.findPlaylistById(id);
        if(playList == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        playlistService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PlayList> getPlaylistById(@PathVariable("id") Long id){
        PlayList playList = playlistService.findPlaylistById(id);
        if (playList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(playList, HttpStatus.OK);
    }
}
