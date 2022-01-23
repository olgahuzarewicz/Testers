package com.interview.app.configuration;


import com.interview.app.helpers.CSVHelper;
import com.interview.app.model.Device;
import com.interview.app.model.Tester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class DataConfiguration {

    private static final Logger log = LoggerFactory.getLogger(DataConfiguration.class);

    @Bean
    List<Device> devices() {
        try (InputStream inputStream = new ClassPathResource("csv/devices.csv").getInputStream()) {
            List<Device> data = CSVHelper.getFromFileCSV(inputStream, Device.class);
            return data;
        } catch (IOException e) {
            log.error("Devices could not be loaded", e);
            return Collections.emptyList();
        }
    }

    @Bean
    List<Tester> testers() {
        try (InputStream inputStream = new ClassPathResource("csv/testers.csv").getInputStream()) {
            List<Tester> data = CSVHelper.getFromFileCSV(inputStream, Tester.class);
            return data;
        } catch (IOException e) {
            log.error("Testers could not be loaded", e);
            return Collections.emptyList();
        }
    }

    @Bean
    List<String> countries(List<Tester> testers) {
        return testers.stream().map(Tester::getCountry).distinct().collect(Collectors.toList());
    }
}