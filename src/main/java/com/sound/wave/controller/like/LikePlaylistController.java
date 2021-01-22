package com.sound.wave.controller.like;

import com.sound.wave.model.PlayList;
import com.sound.wave.model.Song;
import com.sound.wave.model.User;
import com.sound.wave.model.likePlaylist.LikePlaylist;
import com.sound.wave.model.likeSong.LikeSong;
import com.sound.wave.service.like.ILikePlaylistService;
import com.sound.wave.service.playlist.IPlaylistService;
import com.sound.wave.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/like-playlists")
public class LikePlaylistController {
    @Autowired
    private ILikePlaylistService service;
    @Autowired
    private IPlaylistService playlistService;
    @Autowired
    private IUserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<Long> findLikeByPlaylistId(@PathVariable("id") Long id){
        Long number = service.findLikeByPlaylistId(id);
        if (number == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(number, HttpStatus.OK);
    }
    @PostMapping("/like/{p_id}/{u_id}")
    public ResponseEntity<LikePlaylist> likeSong(@PathVariable("p_id") long p_id, @PathVariable("u_id") long u_id){
        LikePlaylist likePlaylist = service.checkLikePlaylist(p_id,u_id);
        if (likePlaylist == null){
            LikePlaylist likePlaylist1 = new LikePlaylist();
            PlayList playList = playlistService.findById(p_id).get();
            User user = userService.findById(u_id).get();
            likePlaylist1.setPlayList(playList);
            likePlaylist1.setUser(user);
            service.save(likePlaylist1);
            return  new ResponseEntity<>(likePlaylist1, HttpStatus.OK);
        }
        else if (!likePlaylist.isStatus()){
            likePlaylist.setStatus(true);
            return new ResponseEntity<>(service.save(likePlaylist), HttpStatus.OK);
        }else {
            likePlaylist.setStatus(false);
            return new ResponseEntity<>(service.save(likePlaylist), HttpStatus.OK);

        }
    }
    @GetMapping("/all-like/{id}")
    public ResponseEntity<Iterable<PlayList>> getAllSongsByUserLike(@PathVariable("id") Long id){
        Iterable<PlayList> playlists = service.findPlaylistsByUserIdAndStatus(id);
        if (playlists == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(playlists,HttpStatus.OK);
    }
    @GetMapping("/like/{id}")
    public ResponseEntity<Long> getLikesByPlaylistId(@PathVariable("id") Long id){
        Long number = service.findLikeByPlaylistId(id);
        if (number == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(number, HttpStatus.OK);
    }
}
