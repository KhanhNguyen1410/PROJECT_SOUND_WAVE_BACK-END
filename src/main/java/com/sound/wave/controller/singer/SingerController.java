package com.sound.wave.controller.singer;

import com.sound.wave.model.Singer;
import com.sound.wave.service.singer.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/singers")
public class SingerController {
    @Autowired
    private ISingerService iSingerService;

    @GetMapping()
    public ResponseEntity<Iterable<Singer>> findAllSinger(){
        return new ResponseEntity<>(iSingerService.findAll(), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Singer> saveSinger(Singer singer){
        return new ResponseEntity<>(iSingerService.save(singer), HttpStatus.CREATED);
    }
}
