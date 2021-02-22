package com.example.OzgurMovie.controller;

import com.example.OzgurMovie.entity.Genre;
import com.example.OzgurMovie.entity.Movie;
import com.example.OzgurMovie.entity.Star;
import com.example.OzgurMovie.service.GenreService;
import com.example.OzgurMovie.service.MovieService;
import com.example.OzgurMovie.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;
    private GenreService genreService;
    private StarService starService;


    public MovieController(MovieService theMovieService, GenreService theGenreService, StarService theStarService){
        this.movieService = theMovieService;
        this.genreService = theGenreService;
        this.starService= theStarService;
    }


    @GetMapping("/list")
    public String listMovies(Model theModel, @RequestParam(defaultValue = "") String title){
//        // pull from moviedb
//        List<Movie> theMovies = movieService.findByTitle(title);
//        theModel.addAttribute("movies", theMovies);
//        return "movies/list-movies";
        return findPaginated(1, "title","asc",theModel);
    }

    @GetMapping("/listGenre")
    public String listMoviesByGenre(Model theModel, @RequestParam(defaultValue = "",required = false) String genreName){
        // pull from moviedb
        Genre genre = genreService.findByName(genreName);
        List<Movie> theMovies = movieService.findByGenre(genre);
        theModel.addAttribute("movies", theMovies);
        return "movies/list-movies";
    }

    // /page/1?sortField=name&sortDire=asc
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo")int pageNo,
                               @RequestParam("sortField") String sortField ,
                               @RequestParam("sortDir") String sortDir ,
                                Model model){
        int pageSize = 5;

        Page<Movie> page = movieService.findPaginated(pageNo, pageSize,sortField,sortDir);
        List<Movie> listMovies = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc": "asc");

        model.addAttribute("listMovies", listMovies);

        return "movies/list-movies";

    }



    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Movie theMovie = new Movie();
        List<Genre> theGenres = genreService.findAll();

        List<Star> theStars = starService.findAll();
        theModel.addAttribute("movie", theMovie);
        theModel.addAttribute("genre", theGenres);

        theModel.addAttribute("stars", theStars);

        // üstteki gibi genre eklemeyi dene

        return "movies/movie-form";
    }

    @GetMapping("/details")
    public String showDetails(@RequestParam("movieId") int id, Model theModel){
        //get from service
        Movie movie = movieService.findById(id);
        List<Genre> theGenres = genreService.findAll();
        //set movie as model and populate
        theModel.addAttribute("movie",movie);
        theModel.addAttribute("genre", theGenres);

        //send
        return "movies/movie-details";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("movieId") int id, Model theModel){
        //get from service
        Movie movie = movieService.findById(id);
        List<Genre> theGenres = genreService.findAll();
        List<Star> theStars = starService.findAll();
        //set movie as model and populate
        theModel.addAttribute("movie",movie);
        theModel.addAttribute("genre", theGenres);
        theModel.addAttribute("stars", theStars);

        //send
        return "movies/movie-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("movieId") int id){

        //delete
        movieService.deleteById(id);


        //redirect to list
        return "redirect:/movies/list";
    }



    @PostMapping("/save")
    public String saveMovie(@ModelAttribute("movie") Movie theMovie){
        //genre dikkat


        movieService.save(theMovie);
        return "redirect:/movies/list";
    }

}
