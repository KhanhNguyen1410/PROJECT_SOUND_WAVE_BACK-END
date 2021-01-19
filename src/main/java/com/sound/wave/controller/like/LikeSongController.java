package com.sound.wave.controller.like;

import com.sound.wave.model.likeSong.LikeSong;
import com.sound.wave.service.like.ILikeSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/like-songs")
public class LikeSongController {
    @Autowired
    private ILikeSongService iLikeSongService;

    @PostMapping("/like")
    public ResponseEntity<LikeSong> likeSong(@RequestBody long id){
        LikeSong likeSong = iLikeSongService.findById(id).get();
        if (likeSong == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(iLikeSongService.save(likeSong), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Long> getLikesBySongId(@PathVariable("id") Long id){
        Long number = iLikeSongService.findLikeBySongId(id);
        if (number == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(number, HttpStatus.OK);
    }


}
