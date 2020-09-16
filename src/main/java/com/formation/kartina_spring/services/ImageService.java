package com.formation.kartina_spring.services;

import com.formation.kartina_spring.models.Image;
import com.formation.kartina_spring.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    private ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public void save(Image image) {
        imageRepository.save(image);
    }

    public List<Image> findAll() {
        return imageRepository.findAll();
    }
}
