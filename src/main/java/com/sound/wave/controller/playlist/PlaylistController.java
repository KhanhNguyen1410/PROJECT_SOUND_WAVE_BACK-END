package com.sound.wave.controller.playlist;

import com.sound.wave.model.PlayList;
import com.sound.wave.service.playlist.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@CrossOrigin("*")
@RequestMapping("/playlists")
public class PlaylistController {
    @Autowired
    private IPlaylistService playlistService;
    @GetMapping("/mostviews")
    public ResponseEntity<Iterable<PlayList>> getPlaylistsByViews(){
        Iterable<PlayList> lists = playlistService.findPlaylistByViews();
        if (lists == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(lists, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<PlayList> savePlaylist(@Valid @RequestBody PlayList playList, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        playList.setDateCreate(LocalDateTime.now());
        playList.setTimeUpdate(LocalDateTime.now());
        return new ResponseEntity<>(playlistService.save(playList),HttpStatus.OK);
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
