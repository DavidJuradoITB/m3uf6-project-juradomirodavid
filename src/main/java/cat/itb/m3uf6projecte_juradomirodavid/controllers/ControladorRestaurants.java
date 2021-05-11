package cat.itb.m3uf6projecte_juradomirodavid.controllers;

import cat.itb.m3uf6projecte_juradomirodavid.model.pojo.Restaurant;
import cat.itb.m3uf6projecte_juradomirodavid.model.service.ServeiRestaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorRestaurants {

    @Autowired
    private ServeiRestaurant service;

    @GetMapping("/list")
    public String llista(Model m) {
        m.addAttribute("llistaRestaurants", service.getAll());
        return "list";
    }

    @GetMapping("/list/eliminar")
    public String eliminarRestaurant(@RequestParam("name") String name) {
        service.deleteRestaurant(name);
        return "redirect:/list";
    }

    @GetMapping("/list/edit/{name}")
    public String editarRestaurant(@PathVariable("name") String name, Model m) {
        m.addAttribute("restaurantForm", service.getByName(name));
        return "add";
    }

    @PostMapping("list/edit/submit")
    public String editarRestaurantSubmit(@ModelAttribute("restaurantForm") Restaurant res) {
        service.updateRestaurant(res);
        return "redirect:/list";
    }

    @GetMapping("/list/add")
    public String addRestaurant(Model m) {
        m.addAttribute("restaurantForm", new Restaurant());
        return "add";
    }

    @PostMapping("/list/add/submit")
    public String addRestaurantSubmit(@ModelAttribute("restaurantForm") Restaurant res) {
        service.afegirRestaurant(res);
        return "redirect:/list";
    }

}
