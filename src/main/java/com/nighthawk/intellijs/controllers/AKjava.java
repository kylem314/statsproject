//package com.nighthawk.intellijs.controllers;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class AKjava {
//    @GetMapping("/aksbout")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
//    public String eric_about(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
//        model.addAttribute("name", name); // MODEL is passed to html
//        return "aksbout"; // returns HTML VIEW (greeting)
//    }
//}
//
