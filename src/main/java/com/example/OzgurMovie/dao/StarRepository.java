package com.example.OzgurMovie.dao;

import com.example.OzgurMovie.entity.Star;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarRepository extends JpaRepository<Star, Integer> {
    Star findByNameLike(String name);
}
