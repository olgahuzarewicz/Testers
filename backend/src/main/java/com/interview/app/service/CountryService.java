package com.interview.app.service;

import com.interview.app.model.Tester;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CountryService {

    private List<Tester> testers;

    public List<String> getCountries() {
        return testers.stream().map(Tester::getCountry).distinct().toList();
    }
}
