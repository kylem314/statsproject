package com.nighthawk.intellijs.controllers;


import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;

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
class Yajatjava {
    @GetMapping("/yajat_about")
    public String weather(Model model) throws IOException, InterruptedException, ParseException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://air-quality.p.rapidapi.com/forecast/airquality?lat=32.732&lon=-117.196&hours=72"))
                .header("x-rapidapi-host", "air-quality.p.rapidapi.com")
                .header("x-rapidapi-key", "bcdf06c872mshbd25dcebbd373b9p1afb3ajsncedd5c4986ed")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        Object obj = new JSONParser().parse(response.body());
        JSONObject jo = (JSONObject) obj;

        JSONArray data = (JSONArray) jo.get("data");
        JSONObject jo2 = (JSONObject) data.get(0);

        model.addAttribute("jo2", jo2);
        model.addAttribute("datetime", jo2.get("datetime"));
        model.addAttribute("aqi", jo2.get("aqi"));

        return "yajat_about";


    }




    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://air-quality.p.rapidapi.com/forecast/airquality?lat=32.732&lon=-117.196&hours=72"))
                .header("x-rapidapi-host", "air-quality.p.rapidapi.com")
                .header("x-rapidapi-key", "bcdf06c872mshbd25dcebbd373b9p1afb3ajsncedd5c4986ed")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        Object obj = new JSONParser().parse(response.body());
        JSONObject jo = (JSONObject) obj;

        JSONArray data = (JSONArray) jo.get("data");
        JSONObject jo2 = (JSONObject) data.get(0);


        System.out.println(data);
    }
}