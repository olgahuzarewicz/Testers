package com.interview.app.controller;

import com.interview.app.dto.TesterDTO;
import com.interview.app.service.TesterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TesterController {

    private TesterService testerService;

    @GetMapping("/testers")
    public List<TesterDTO> getTesters(@RequestParam(required = false) List<String> countries, @RequestParam(required = false) List<Integer> devices) {
        return testerService.getTesters(countries, devices);
    }
}
