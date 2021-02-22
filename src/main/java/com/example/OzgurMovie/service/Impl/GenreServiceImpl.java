package com.example.OzgurMovie.service.Impl;

import com.example.OzgurMovie.dao.GenreRepository;
import com.example.OzgurMovie.entity.Genre;
import com.example.OzgurMovie.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl  implements GenreService {

    private GenreRepository genreRepository;
    @Autowired
    public GenreServiceImpl(GenreRepository theGenreRepository){
        this.genreRepository = theGenreRepository;
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre findById(int id) {
        Optional<Genre> result =genreRepository.findById(id);
        Genre theGenre = null;

        if (result.isPresent()){
            theGenre = result.get();
        }else {
            throw  new RuntimeException("Could not found the genre with id: "+id);
        }

        return theGenre;
    }

    @Override
    public void save(Genre genre) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Genre findByName(String name) {
        return genreRepository.findByNameLike("%"+ name+"%");
    }



}
