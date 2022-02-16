package com.example.demo;

import com.example.demo.dto.DogDto;
import com.example.demo.service.DtoDogServiceImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.test.util.ReflectionTestUtils;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class TestInterfaceImp {

    @Autowired
    DtoDogServiceImp dogDtoServiceImp;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private DtoDogServiceImp interfaceImp = new DtoDogServiceImp();

    @Before
    public void setUp() {
        ReflectionTestUtils.setField(interfaceImp, "url", "http://localhost:8080/dog");
    }

    @Test
    public void test() {
        List<DogDto> dogDtos = new ArrayList<>();
        dogDtos.add(new DogDto());

        String string = "http://localhost:8080/dog";

        Mockito.when(restTemplate.getForObject(string, List.class))
                .thenReturn(dogDtos);

        List<DogDto> result = interfaceImp.findAll();
        Assert.assertEquals(result, dogDtos);
    }
}