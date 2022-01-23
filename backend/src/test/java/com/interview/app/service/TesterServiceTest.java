package com.interview.app.service;

import com.interview.app.dto.TesterDTO;
import com.interview.app.model.Bug;
import com.interview.app.model.Tester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TesterServiceTest {

    TesterService testerService;

    @BeforeEach
    void setup() {
        List<Tester> testers = initializeTesters();
        List<Bug> bugs = initializeBugs();

        testerService = new TesterService(testers, bugs);
    }

    @Test
    void getTesters() {
        List<TesterDTO> result = testerService.getTesters(null, null);

        assertEquals(4, result.size());

        assertEquals(2, result.get(0).id());
        assertEquals("bbb", result.get(0).firstName());
        assertEquals("BBB", result.get(0).lastName());
        assertEquals(2, result.get(0).experience());

        assertEquals(1, result.get(1).id());
        assertEquals("aaa", result.get(1).firstName());
        assertEquals("AAA", result.get(1).lastName());
        assertEquals(1, result.get(1).experience());

        assertEquals(3, result.get(2).id());
        assertEquals("ccc", result.get(2).firstName());
        assertEquals("CCC", result.get(2).lastName());
        assertEquals(1, result.get(2).experience());

        assertEquals(4, result.get(3).id());
        assertEquals("ddd", result.get(3).firstName());
        assertEquals("DDD", result.get(3).lastName());
        assertEquals(0, result.get(3).experience());
    }

    @Test
    void getTestersFromUS() {
        List<TesterDTO> result = testerService.getTesters(List.of("US"), null);

        assertEquals(2, result.size());

        assertEquals(2, result.get(0).id());
        assertEquals("bbb", result.get(0).firstName());
        assertEquals("BBB", result.get(0).lastName());
        assertEquals(2, result.get(0).experience());

        assertEquals(1, result.get(1).id());
        assertEquals("aaa", result.get(1).firstName());
        assertEquals("AAA", result.get(1).lastName());
        assertEquals(1, result.get(1).experience());
    }

    @Test
    void getTestersUsingiPhone4() {
        List<TesterDTO> result = testerService.getTesters(null, List.of(1));

        assertEquals(1, result.size());

        assertEquals(1, result.get(0).id());
        assertEquals("aaa", result.get(0).firstName());
        assertEquals("AAA", result.get(0).lastName());
        assertEquals(1, result.get(0).experience());
    }

    @Test
    void getTestersFromGBUsingiPhone4() {
        List<TesterDTO> result = testerService.getTesters(List.of("PL"), List.of(1));

        assertEquals(0, result.size());
    }

    @Test
    void getTestersFromGBUsingGalaxyS4() {
        List<TesterDTO> result = testerService.getTesters(List.of("GB"), List.of(5));

        assertEquals(1, result.size());

        assertEquals(3, result.get(0).id());
        assertEquals("ccc", result.get(0).firstName());
        assertEquals("CCC", result.get(0).lastName());
        assertEquals(1, result.get(0).experience());
    }

    private List<Tester> initializeTesters() {
        return List.of(
                new Tester(1, "aaa", "AAA", "US", "", Set.of(1, 2, 5)),
                new Tester(2, "bbb", "BBB", "US", "", Set.of(3, 5)),
                new Tester(3, "ccc", "CCC", "GB", "", Set.of(3, 5, 6)),
                new Tester(4, "ddd", "DDD", "PL", "", Set.of(7, 8, 10)));
    }

    private List<Bug> initializeBugs() {
        return List.of(
                new Bug(1, 1, 1),
                new Bug(1, 3, 2),
                new Bug(2, 5, 2),
                new Bug(1, 5, 3));
    }
}