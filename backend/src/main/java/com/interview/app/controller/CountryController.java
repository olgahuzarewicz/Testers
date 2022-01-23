package com.interview.app.controller;

import com.interview.app.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CountryController {

    private CountryService countryService;

    @GetMapping("/countries")
    public List<String> getCountries() {
        return countryService.getCountries();
    }
}
