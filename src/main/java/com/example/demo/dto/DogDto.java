package com.example.demo.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DogDto {

    private Integer id;

    private String name;

    private Integer age;

    private Integer num;

}
