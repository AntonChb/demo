package com.example.demo.service;

import com.example.demo.dto.DogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DtoDogServiceImp implements DtoDogService {

    @Value("${service.url}")
    public String url;

    @Autowired
    DtoDogService dtoDogService;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<DogDto> findAll() {
        List<DogDto> result = restTemplate.getForObject(url, List.class);

        return result;
    }
    //    @Override
//    public List<DogDto> findAll() {
//        return inter.findAll();
//    }
}
