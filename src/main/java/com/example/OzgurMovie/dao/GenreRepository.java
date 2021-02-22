package com.example.OzgurMovie.dao;

import com.example.OzgurMovie.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Genre findByNameLike(String name);
}
