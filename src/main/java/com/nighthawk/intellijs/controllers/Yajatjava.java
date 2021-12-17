package com.nighthawk.intellijs.controllers;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


//@Controller
//public class Yajatjava {
//    @GetMapping("/yajat_about")
//
//    public String yajat_about(Model model) {
//
//        String name = "test";
//        model.addAttribute("name", name); // MODEL is passed to html
//        return "yajat_about"; // returns HTML VIEW (greeting)
//    }
//}



@Controller
public class Yajatjava {
    @GetMapping("/yajat_about")
    public String weather(Model model) throws IOException, InterruptedException, ParseException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://weatherapi-com.p.rapidapi.com/ip.json?q=%3CREQUIRED%3E"))
                .header("x-rapidapi-host", "weatherapi-com.p.rapidapi.com")
                .header("x-rapidapi-key", "bcdf06c872mshbd25dcebbd373b9p1afb3ajsncedd5c4986ed")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        Object obj = new JSONParser().parse(response.body());
        JSONObject jo = (JSONObject) obj;

        JSONObject current_data = (JSONObject) jo.get("current");



//        String update = data.get("last_updated").toString();



        model.addAttribute("jo", jo);
        model.addAttribute("data", jo.get("current"));
//        model.addAttribute("temp", current_data.get("temp_f") );
//        model.addAttribute("wind_mph", current_data.get("wind_mph").toString() );
//        model.addAttribute("humidity", current_data.get("humidity").toString() );
//        model.addAttribute("last_updated", update );

        return "yajat_about";


    }

//
//    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
//        System.out.println(jo.get);




    }
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://weatherapi-com.p.rapidapi.com/current.json?q=San%20Diego"))
//                .header("x-rapidapi-host", "weatherapi-com.p.rapidapi.com")
//                .header("x-rapidapi-key", "bcdf06c872mshbd25dcebbd373b9p1afb3ajsncedd5c4986ed")
//                .method("GET", HttpRequest.BodyPublishers.noBody())
//                .build();
//        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        Object obj = new JSONParser().parse(response.body());
//        JSONObject jo = (JSONObject) obj;
//
////         JSONObject data = jo.get("current");
////        JSONObject jo2 = (JSONObject) data.get(0);
//
//        JSONObject data = (JSONObject) jo.get("current");
//
//        System.out.println(jo.get("current").toString());
//
//System.out.println(jo.get("current"));
//        System.out.println(data.get("temp_f")  );
//        System.out.println( data.get("wind_mph").toString() );
//        System.out.println( data.get("humidity").toString()  );
//        System.out.println( data.get("last_updated").toString()  );
////        System.out.println(jo2.get("aqi").toString());
//    }



