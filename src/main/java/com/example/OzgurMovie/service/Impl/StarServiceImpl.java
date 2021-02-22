package com.example.OzgurMovie.service.Impl;

import com.example.OzgurMovie.dao.GenreRepository;
import com.example.OzgurMovie.dao.StarRepository;
import com.example.OzgurMovie.entity.Genre;
import com.example.OzgurMovie.entity.Star;
import com.example.OzgurMovie.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StarServiceImpl implements StarService {
    private StarRepository starRepository;
    @Autowired
    public StarServiceImpl(StarRepository theStarRepository){
        this.starRepository = theStarRepository;
    }

    @Override
    public List<Star> findAll() {
        return starRepository.findAll();
    }

    @Override
    public Star findById(int id) {
        Optional<Star> result =starRepository.findById(id);
        Star theStar = null;

        if (result.isPresent()){
            theStar = result.get();
        }else {
            throw  new RuntimeException("Could not found the genre with id: "+id);
        }

        return theStar;
    }

    @Override
    public void save(Star star) {
    starRepository.save(star);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Star findByName(String name) {
        return starRepository.findByNameLike("%"+ name+"%"); }


}
