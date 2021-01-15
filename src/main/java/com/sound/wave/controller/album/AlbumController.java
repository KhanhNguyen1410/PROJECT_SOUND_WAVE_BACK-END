package com.sound.wave.controller.album;

import com.sound.wave.model.Album;
import com.sound.wave.service.album.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    private IAlbumService iAlbumService;

    @GetMapping()
    public ResponseEntity<Iterable<Album>> findAllAlbum(){
        return new ResponseEntity<>(iAlbumService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbum(@PathVariable long id) {
        return new ResponseEntity<>(iAlbumService.findById(id).get(), HttpStatus.OK);
    }
}
