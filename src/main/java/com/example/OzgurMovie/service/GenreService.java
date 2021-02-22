package com.example.OzgurMovie.service;

import com.example.OzgurMovie.entity.Genre;

import java.util.List;

public interface GenreService {

    public List<Genre> findAll();
    public Genre findById(int id);
    public void save(Genre genre);
    public void deleteById(int id);

    Genre findByName(String name);
}
