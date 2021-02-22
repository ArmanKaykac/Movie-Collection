package com.example.OzgurMovie.controller;


import com.example.OzgurMovie.entity.Star;
import com.example.OzgurMovie.service.StarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("star")
public class StarController {

    private StarService starService;


    public StarController(StarService theStarService){
        this.starService = theStarService;
    }

    @GetMapping("/list")
    public String list(Model theModel) {
        List<Star> stars = starService.findAll();
        theModel.addAttribute("stars", stars);
        return "movies/list-stars";
    }

    @GetMapping("/add-star")
    public String add(Model model) {
        Star star = new Star();
        model.addAttribute("star", star);
        return "movies/star-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        starService.deleteById(id);
        return "redirect:/star/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("star") Star theStar) {
        starService.save(theStar);
        System.out.println(theStar.getName());
        return "redirect:/star/list";
    }

}
