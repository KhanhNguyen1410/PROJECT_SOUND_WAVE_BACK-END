package com.sound.wave.controller.comment;

import com.sound.wave.model.commentPlaylist.CommentPlaylist;
import com.sound.wave.service.commentPlaylist.ICommentPlaylist;
import com.sound.wave.service.playlist.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/comment-playlists")
public class CommentPlaylistController {
    @Autowired
    private ICommentPlaylist commentPlaylist;

    @GetMapping("/{id}")
    public ResponseEntity<List<CommentPlaylist>> findCommentByPlaylistId(@PathVariable("id") Long id){
        List<CommentPlaylist> commentPlaylists = commentPlaylist.findCommentPlaylistsByPlaylistId(id);
        if (commentPlaylists == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(commentPlaylists, HttpStatus.OK);
    }
}
