package com.sound.wave.controller.album;

import com.sound.wave.model.Album;
import com.sound.wave.service.album.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private IAlbumService iAlbumService;

    @GetMapping()
    public ResponseEntity<Iterable<Album>> findAllAlbum(){
        return new ResponseEntity<>(iAlbumService.findAll(), HttpStatus.OK);
    }

}
