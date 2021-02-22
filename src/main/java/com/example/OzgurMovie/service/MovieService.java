package com.example.OzgurMovie.service;

import com.example.OzgurMovie.entity.Genre;
import com.example.OzgurMovie.entity.Movie;
import org.springframework.data.domain.Page;

import java.util.List;


public interface MovieService {

    public List<Movie> findAll();
    public Movie findById(int id);
    public void save(Movie movie);
    public void deleteById(int id);

    List<Movie> findByTitle(String title);

    List<Movie> findByGenre(Genre genre);
    Page<Movie> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
