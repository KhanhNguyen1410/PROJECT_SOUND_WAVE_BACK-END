package com.sound.wave.controller.comment;

import com.sound.wave.model.commentSong.CommentSong;
import com.sound.wave.service.CommentSong.ICommentSong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@CrossOrigin("*")
@RequestMapping("/comment-songs")
public class CommentSongController {
    @Autowired
    private ICommentSong iCommentSong;

    @GetMapping("/song/{id}")
    public ResponseEntity<Iterable<CommentSong>> findCommentsBySongId(@PathVariable("id")Long id){
        Iterable<CommentSong> commentSongIterable = iCommentSong.findCommentsBySongId(id);
        if (commentSongIterable == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(commentSongIterable, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CommentSong> getCommentSongById(@PathVariable("id") Long id){
        CommentSong commentSong= iCommentSong.findById(id).get();
        if (commentSong == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(commentSong, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<CommentSong> addCommentSong(@Valid @RequestBody CommentSong commentSong, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        commentSong.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(iCommentSong.save(commentSong), HttpStatus.OK);
    }
}
