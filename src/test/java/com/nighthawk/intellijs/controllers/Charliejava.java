package com.nighthawk.intellijs.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;
import java.util.*;

import java.util.HashMap;

import org.json.*;

@Controller
public class Charliejava {
    @GetMapping("/charlieabout")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String charlie_about(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
        model.addAttribute("name", name); // MODEL is passed to html
        return "charlieabout"; // returns HTML VIEW (greeting)
    }
    @GetMapping("/home")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String home(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
        model.addAttribute("name", name); // MODEL is passed to html
        return "home"; // returns HTML VIEW (greeting)
    }
}