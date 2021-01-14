package com.sound.wave.service.category;

import com.sound.wave.model.Category;
import com.sound.wave.repository.category.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ICategoryServiceIPL implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;


    @Override
    public Iterable<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return iCategoryRepository.save(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return iCategoryRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
            iCategoryRepository.deleteById(id);
    }
}
