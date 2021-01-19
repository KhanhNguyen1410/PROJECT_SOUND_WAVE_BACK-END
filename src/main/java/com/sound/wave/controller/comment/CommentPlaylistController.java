package com.sound.wave.controller.comment;

import com.sound.wave.model.PlayList;
import com.sound.wave.model.commentPlaylist.CommentPlaylist;
import com.sound.wave.service.commentPlaylist.ICommentPlaylist;
import com.sound.wave.service.playlist.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/comment-playlists")
public class CommentPlaylistController {
    @Autowired
    private ICommentPlaylist iCommentPlaylist;

    @GetMapping("/comment/{id}")
    public ResponseEntity<List<CommentPlaylist>> findCommentByPlaylistId(@PathVariable("id") Long id){
        List<CommentPlaylist> commentPlaylists = iCommentPlaylist.findCommentPlaylistsByPlaylistId(id);
        if (commentPlaylists == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(commentPlaylists, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<CommentPlaylist> addCommentPlaylist(@Valid @RequestBody CommentPlaylist commentPlaylist1, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        commentPlaylist1.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(iCommentPlaylist.save(commentPlaylist1), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CommentPlaylist> getPlaylistById(@PathVariable("id") Long id){
        CommentPlaylist commentPlaylist = iCommentPlaylist.findById(id).get();
        if (commentPlaylist == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(commentPlaylist, HttpStatus.OK);
    }
}
