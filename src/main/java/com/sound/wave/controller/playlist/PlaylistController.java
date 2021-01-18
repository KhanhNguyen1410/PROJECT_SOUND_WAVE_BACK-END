package com.sound.wave.controller.playlist;

import com.sound.wave.model.PlayList;
import com.sound.wave.service.playlist.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
