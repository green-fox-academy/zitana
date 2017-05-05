package com.greenfoxacademy.foxclub.controller;

import com.greenfoxacademy.foxclub.model.Drink;
import com.greenfoxacademy.foxclub.model.Food;
import com.greenfoxacademy.foxclub.model.Fox;
import com.greenfoxacademy.foxclub.model.Trick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
  @Autowired
  Fox fox;

  @RequestMapping("/")
  public String displayInfo(Model model) {
    model.addAttribute("fox", fox);
    return "index";
  }

  @RequestMapping("/nutritionStore")
  public String displayStore(Model model) {
    model.addAttribute("fox", fox);
    model.addAttribute("food", Food.foodList);
      model.addAttribute("drink", Drink.drinkList);
    return "store";
  }

  @RequestMapping("/trickCenter")
  public String displayTrickCenter(Model model) {
    model.addAttribute("fox", fox);
    model.addAttribute("tricks", Trick.trickList);
    return "tricks";
  }

  @RequestMapping("/changeNutrition")
  public String changeDiet(Model model, @RequestParam(value ="food") int foodId, @RequestParam(value = "drink") int drinkId) {
    fox.setFood(Food.getById(foodId));
    fox.setDrink(Drink.getById(drinkId));
    model.addAttribute("fox", fox);
    return "index";
  }

  @GetMapping("/learnTrick")
  public String addTrick(Model model, @RequestParam("trick") int trickId) {
    fox.learnTricks(Trick.getById(trickId));
    model.addAttribute("fox", fox);
    return "index";
  }

//  @RequestMapping("/reset")
//  public String addTrick(Model model) {
//    model.addAttribute("fox", fox);
//    return "index";
//  }

}