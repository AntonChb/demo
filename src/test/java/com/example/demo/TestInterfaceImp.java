package com.example.demo;

import com.example.demo.dto.DogDto;
import com.example.demo.service.DtoDogServiceImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

//import org.mockito.Mock;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TestInterfaceImp {

    @Mock
    private DemoApplicationService demoApplicationService;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    DemoApplication demoApplication = new DemoApplication();

    @InjectMocks
    private DtoDogServiceImp dogDtoServiceImp = new DtoDogServiceImp();

    @Before
    public void setUp() {
        ReflectionTestUtils.setField(dogDtoServiceImp, "url", "http://localhost:8080/dog");
    }

    @Test
    public void test() {
        List<DogDto> dogDtos = new ArrayList<>();
        dogDtos.add(new DogDto());

        String string = "http://localhost:8080/dog";

        Mockito.when(restTemplate.getForObject(string, List.class))
                .thenReturn(dogDtos);

        List<DogDto> result = dogDtoServiceImp.findAll();
        Assert.assertEquals(result, dogDtos);
    }
    @Test
    public void testGetSum() throws Exception {
        DemoApplication demoApplication = new DemoApplication();
        assertEquals(3, demoApplication.sum(1, 2));
    }

    @Test
    public void testGetMultiply() throws Exception {
        DemoApplication demoApplication = new DemoApplication();
        assertEquals(9, demoApplication.result(3, 3));
    }

    @Test
    public void testGetMultiply2() throws Exception {
        MockitoAnnotations.initMocks(this);
        //Mockito.when(demoApplicationService.multiply(3,3)).thenReturn(9);
        Mockito.when(demoApplicationService.multiply(any(),any())).thenReturn(5);
        int s = 9;
        int res = demoApplication.result(3,3);
        assertEquals(s, res);
    }
}