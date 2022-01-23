package com.interview.app.service;

import com.interview.app.model.Tester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountryServiceTest {

    CountryService countryService;

    @BeforeEach
    void setup() {
        List<Tester> testers = initializeTesters();
        countryService = new CountryService(testers);
    }

    @Test
    void getCountries() {
        List<String> result = countryService.getCountries();

        assertEquals(3, result.size());
        assertEquals("US", result.get(0));
        assertEquals("GB", result.get(1));
        assertEquals("PL", result.get(2));
    }

    private List<Tester> initializeTesters() {
        return List.of(
                new Tester(1, "aaa", "AAA", "US", "", Set.of(1, 2, 3, 10)),
                new Tester(2, "bbb", "BBB", "US", "", Set.of(4, 5)),
                new Tester(1, "ccc", "CCC", "GB", "", Set.of(3, 5, 6)),
                new Tester(2, "ddd", "DDD", "PL", "", Set.of(7, 8, 10)));
    }
}