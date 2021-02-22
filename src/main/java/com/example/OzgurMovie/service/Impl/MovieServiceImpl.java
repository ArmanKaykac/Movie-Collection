package com.example.OzgurMovie.service.Impl;

import com.example.OzgurMovie.dao.MovieRepository;
import com.example.OzgurMovie.entity.Genre;
import com.example.OzgurMovie.entity.Movie;
import com.example.OzgurMovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;
    @Autowired
    public MovieServiceImpl(MovieRepository theMovieRepository){
        this.movieRepository = theMovieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAllByOrderByTitleAsc();
    }

    @Override
    public Movie findById(int id) {
        Optional<Movie> result = movieRepository.findById(id);

        Movie theMovie = null;

        if(result.isPresent()){
            theMovie = result.get();
        }else{
            throw  new RuntimeException("Could not found the movie with id: "+id);
        }

        return theMovie;
    }

    @Override
    public void save(Movie movie) {
    movieRepository.save(movie);
    }

    @Override
    public void deleteById(int id) {
    movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> findByTitle(String title) {
        return movieRepository.findByTitleLike("%"+title+"%");
    }

    @Override
    public List<Movie> findByGenre(Genre genre) {
        return movieRepository.findByGenre(genre);
    }

    @Override
    public Page<Movie> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortField).ascending():
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo-1, pageSize, sort);
        return this.movieRepository.findAll(pageable);
    }
}
