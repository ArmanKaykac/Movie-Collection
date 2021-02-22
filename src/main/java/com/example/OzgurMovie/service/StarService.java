package com.example.OzgurMovie.service;

import com.example.OzgurMovie.entity.Genre;
import com.example.OzgurMovie.entity.Star;

import java.util.List;

public interface StarService {
    public List<Star> findAll();
    public Star findById(int id);
    public void save(Star star);
    public void deleteById(int id);

    Star findByName(String name);
}
