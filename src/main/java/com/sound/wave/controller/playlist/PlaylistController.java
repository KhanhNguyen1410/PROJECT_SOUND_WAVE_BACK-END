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
@RequestMapping("/playlist")
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
        Optional<PlayList> playListOptional= playlistService.findById(id);
        if (playListOptional == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        playListOptional.get().setName(playList.getName());
        playListOptional.get().setCategory(playList.getCategory());
        playListOptional.get().setDescription(playList.getDescription());
        playListOptional.get().setDateCreate(playList.getDateCreate());
        playListOptional.get().setTimeUpdate(playList.getTimeUpdate());
        playlistService.save(playListOptional.get());
        return  new ResponseEntity<>(playListOptional.get(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<PlayList> deletePlaylist(@PathVariable("id") Long id){
        Optional<PlayList> playList = playlistService.findById(id);
        if(playList.get() == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        playlistService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
