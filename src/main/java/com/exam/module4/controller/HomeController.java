package com.exam.module4.controller;


import com.exam.module4.model.City;
import com.exam.module4.model.Country;
import com.exam.module4.service.CityService;
import com.exam.module4.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    CityService cityService;

    @Autowired
    CountryService countryService;

    @GetMapping("")
    public String getindex(){
        return "index";
    }

    @ModelAttribute(name = "cities")
    public Iterable<City> cities(){
        return cityService.findAll();
    }

    @ModelAttribute(name = "allCountry")
    public Iterable<Country> countries(){
        return countryService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView mv = new ModelAndView("create");
        mv.addObject("newcity",new City());
        return mv;
    }

    @PostMapping("/create")
    public ModelAndView createCity(@ModelAttribute("newcity") City city, @RequestParam("country")Long countryid){
        ModelAndView mv = new ModelAndView("create");
        if(cityService.save(city)!= null){
            mv.addObject("mess","create successful");
            mv.addObject("newcity",new City());
        }else {
            mv.addObject("mess","create not successful");
            mv.addObject("newcity",city);
        }
        return mv;

    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("edit");
        mv.addObject("editCity",cityService.findOne(id));
        return mv;
    }

    @PostMapping("edit/{id}")
    public ModelAndView editCity(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("edit");
        City editCity = cityService.findOne(id);
        if(cityService.save(editCity)!=null){
            mv.addObject("mess","update info successful");
            mv.addObject("newcity",new City());
        }else {
            mv.addObject("mess","update fail");
            mv.addObject("newcity",editCity);
        }
        return mv;
    }

    @GetMapping("detail/{id}")
    public ModelAndView showDetail(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("detail");
        City detailCity = cityService.findOne(id);
        mv.addObject("detailCity",detailCity);
        return mv;
    }

    @PostMapping("delete/{id}")
    public String deleteCity(@PathVariable Long id){
        City deleteCity = cityService.findOne(id);
        cityService.delete(id);
        return ("redirect:/");
    }
}
