package com.sound.wave.controller.like;

import com.sound.wave.service.like.ILikePlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/like-playlists")
public class LikePlaylistController {
    @Autowired
    private ILikePlaylistService service;
    @GetMapping("/{id}")
    public ResponseEntity<Long> findLikeByPlaylistId(@PathVariable("id") Long id){
        Long number = service.findLikeByPlaylistId(id);
        if (number == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(number, HttpStatus.OK);
    }
}
