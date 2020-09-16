package com.formation.kartina_spring.services;

import com.formation.kartina_spring.models.Tag;
import com.formation.kartina_spring.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public void save(Tag tag){
        tagRepository.save(tag);
    }

    public List<Tag> findAll(){
        return tagRepository.findAll();
    }
}
