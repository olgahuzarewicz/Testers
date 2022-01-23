package com.interview.app.configuration;

import com.interview.app.model.Bug;
import com.interview.app.model.Tester;
import com.interview.app.service.CountryService;
import com.interview.app.service.TesterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ServiceConfiguration {

    @Bean
    CountryService countryService(List<Tester> testers) {
        return new CountryService(testers);
    }

    @Bean
    TesterService testerService(List<Tester> testers, List<Bug> bugs) {
        return new TesterService(testers, bugs);
    }
}
