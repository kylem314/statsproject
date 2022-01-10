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
import org.springframework.web.bind.annotation.RequestParam;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



@Controller
public class Yajatjava {

//    @GetMapping("/yajat_about")
//    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
//    public String yajat_about(@RequestParam(name = "name", required = false, defaultValue = "x") String name, Model model) {
//        // @RequestParam handles required and default values, name and model are class variables, model looking like JSON
//        model.addAttribute("name", name); // MODEL is passed to html
//        return "yajat_about"; // returns HTML VIEW (greeting)
//    }

        @GetMapping("/yajat_about")
        public String yajat_about(Model model) throws IOException, InterruptedException, ParseException {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://weatherapi-com.p.rapidapi.com/current.json?q=San%20Diego"))
                    .header("x-rapidapi-host", "weatherapi-com.p.rapidapi.com")
                    .header("x-rapidapi-key", "bcdf06c872mshbd25dcebbd373b9p1afb3ajsncedd5c4986ed")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            Object obj = new JSONParser().parse(response.body());
            JSONObject jo = (JSONObject) obj;
            JSONObject current = (JSONObject) jo.get("current");


            model.addAttribute("temp", current.get("temp_f").toString());
            model.addAttribute("wind_mph", current.get("wind_mph").toString());
            model.addAttribute("humidity", current.get("humidity").toString());
            model.addAttribute("last_updated", current.get("last_updated").toString());

            return "yajat_about";
        }

//
//
//            //
//////    FRQ Unit 4 Question 1
////public String longestStreak(String str){
////
////    String previous = str.substring(0,1);
////    String longest = "";
////    String current = "";
////
////
////    for (int x = 0; x < str.length(); x++){
////
////        if (str.substring(x, x + 1).equals(previous)){
////
////            current += str.substring(x, x+1);
////            previous = str.substring(x, x+1);
////
////            if (current.length() > longest.length() ){
////                longest = current;
////            }
////
////
////        }
////
////        else{
////            current = "";
////        }
////
////    }
////
////    return longest.substring(0,1) + " " + longest.length();
////
////}
//        }


    ////
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
////        System.out.println(jo.get);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://weatherapi-com.p.rapidapi.com/current.json?q=San%20Diego"))
                .header("x-rapidapi-host", "weatherapi-com.p.rapidapi.com")
                .header("x-rapidapi-key", "bcdf06c872mshbd25dcebbd373b9p1afb3ajsncedd5c4986ed")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        Object obj = new JSONParser().parse(response.body());
        JSONObject jo = (JSONObject) obj;

        JSONObject current = (JSONObject) jo.get("current");

        System.out.println(current.get("uv"));


//
//        JSONObject current_data = (JSONObject) jo.get("current");
//        System.out.println(current_data);
    }

    //
////
//////
//////
//////
//////        HttpRequest request = HttpRequest.newBuilder()
//////                .uri(URI.create("https://weatherapi-com.p.rapidapi.com/current.json?q=San%20Diego"))
//////                .header("x-rapidapi-host", "weatherapi-com.p.rapidapi.com")
//////                .header("x-rapidapi-key", "bcdf06c872mshbd25dcebbd373b9p1afb3ajsncedd5c4986ed")
//////                .method("GET", HttpRequest.BodyPublishers.noBody())
//////                .build();
//////        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//////        Object obj = new JSONParser().parse(response.body());
//////        JSONObject jo = (JSONObject) obj;
//////
//////         JSONObject data = (JSONObject) jo.get("current");
////// JSONObject jo2 = (JSONObject) data.get(0);
//////        JSONObject data = (JSONObject) jo.get("current");
//////
//////        System.out.println(jo.get("current").toString());
//////
//////System.out.println(jo.get("current"));
//////        System.out.println(data.get("temp_f")  );
//////        System.out.println( data.get("wind_mph").toString() );
//////        System.out.println( data.get("humidity").toString()  );
//////        System.out.println( data.get("last_updated").toString()  );
//////        System.out.println(jo2.get("aqi").toString());
//////    }
//
//
//        }


}




