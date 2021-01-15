package com.sound.wave.controller.category;

import com.sound.wave.model.Category;
import com.sound.wave.model.Singer;
import com.sound.wave.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping()
    public ResponseEntity<Iterable<Category>> findAllCategory(){
        return new ResponseEntity<>(iCategoryService.findAll(), HttpStatus.CREATED);
    }

}
