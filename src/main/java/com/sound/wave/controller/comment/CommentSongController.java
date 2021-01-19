package com.sound.wave.controller.comment;

import com.sound.wave.model.commentSong.CommentSong;
import com.sound.wave.service.CommentSong.ICommentSong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/comment-songs")
public class CommentSongController {
    @Autowired
    private ICommentSong iCommentSong;

    @GetMapping("/{id}")
    public ResponseEntity<Iterable<CommentSong>> findCommentsBySongId(@PathVariable("id")Long id){
        Iterable<CommentSong> commentSongIterable = iCommentSong.findCommentsBySongId(id);
        if (commentSongIterable == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(commentSongIterable, HttpStatus.OK);
    }
}
