package com.sound.wave.controller.like;

import com.sound.wave.model.Song;
import com.sound.wave.model.User;
import com.sound.wave.model.likeSong.LikeSong;
import com.sound.wave.service.like.ILikeSongService;
import com.sound.wave.service.song.ISongService;
import com.sound.wave.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("songs")
public class LikeSongController {
    @Autowired
    private ILikeSongService iLikeSongService;
    @Autowired
    private ISongService iSongService;
    @Autowired
    private IUserService iUserService;
    @GetMapping("/all-like")
    public ResponseEntity<Iterable<LikeSong>> getAllLike(){
        return new ResponseEntity<>(iLikeSongService.findAll(), HttpStatus.OK);
    }
    @PostMapping("like/{s_id}/{u_id}")
    public ResponseEntity<LikeSong> likeSong(@PathVariable("s_id") long s_id, @PathVariable("u_id") long u_id){
        LikeSong likeSong = iLikeSongService.findLikeSongByUserAndSong(s_id,u_id);
        if (likeSong == null){
            Song song = iSongService.findById(s_id).get();
            User user = iUserService.findById(u_id).get();
            likeSong.setSong(song);
            likeSong.setUser(user);
            return  new ResponseEntity<>(iLikeSongService.save(likeSong), HttpStatus.OK);
        }
        else if (!likeSong.isStatus()){
            likeSong.setStatus(true);
            return new ResponseEntity<>(iLikeSongService.save(likeSong), HttpStatus.OK);
        }else {
            likeSong.setStatus(false);
            return new ResponseEntity<>(iLikeSongService.save(likeSong), HttpStatus.OK);

        }
    }

//    boolean checkLike()
}
