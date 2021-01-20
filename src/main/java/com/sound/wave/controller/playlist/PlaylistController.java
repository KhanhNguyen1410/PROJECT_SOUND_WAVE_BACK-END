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

    @GetMapping()
    public ResponseEntity<Iterable<PlayList>> getAllPlaylist(){
        Iterable<PlayList> lists = playlistService.findAll();
        if (lists == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(lists, HttpStatus.OK);
    }
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
    @PutMapping("/{id}/{id1}")
    public ResponseEntity<PlayList> updatePlaylist( @PathVariable("id") Long id, @PathVariable("id1") Long id1,@Valid @RequestBody PlayList playList,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        PlayList playList1= playlistService.findPlaylistByIdAndUserId(id, id1);
        if (playList1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        playList1.setTimeUpdate(LocalDateTime.now());
        playList1.setName(playList.getName());
        playList1.setDescription(playList.getDescription());
        playlistService.save(playList1);
        return new ResponseEntity<>(playList1,HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<Iterable<PlayList>> getPlaylistByUserId(@PathVariable("id") Long id){
        Iterable<PlayList> playLists = playlistService.findPlaylistsByUserId(id);
        if (playLists == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(playLists, HttpStatus.OK);
    }

}
