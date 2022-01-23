package com.interview.app.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CountryController {

    List<String> countries;

    @GetMapping("/countries")
    public List<String> getCountries() {
        return countries;
    }
}
