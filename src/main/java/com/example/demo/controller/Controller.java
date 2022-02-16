package com.example.demo.controller;

import com.example.demo.dto.DogDto;
import com.example.demo.service.DtoDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private DtoDogService inter;

    @GetMapping(path = "/dogg")
    public List<DogDto> getAllDogs() {
        return inter.findAll();
    }

//    @GetMapping(path = "/dogdto")
//    public DogDto oneDog() {
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        DogDto res = restTemplate.getForObject("http://localhost:8080//dogid1", DogDto.class);
//        return res; //Создал контроллер(url //dogid1) которы дога выводит по первой айдихе(id=1)
//        // и дернул его, все работает, узнай у Костяна как лист дернуть
//    }
//
//    @GetMapping(path = "/getst")
//    public String getString() {
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        String st = restTemplate.getForObject("http://localhost:8080//st", String.class);
//        return st;
//    }
//
//    @GetMapping(path = "/st2")
//    public String getSt() {
//        return "Хf[f[f[ff[";
//    }
    //    @GetMapping(path = "/alldog")
//    public List<DogDto> allDog() {
//
//        RestTemplate restTemplate = new RestTemplate();
//        List<DogDto> result = restTemplate.getForObject(url, List.class);
//
//        return result;
//    }
}