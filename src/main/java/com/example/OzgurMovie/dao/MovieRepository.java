package com.example.OzgurMovie.dao;

import com.example.OzgurMovie.entity.Genre;
import com.example.OzgurMovie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    public List<Movie> findAllByOrderByTitleAsc();

    List<Movie> findByTitleLike(String title);

    List<Movie> findByGenre(Genre genre);
}
