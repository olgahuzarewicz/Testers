package com.interview.app.configuration;

import com.interview.app.helpers.CSVHelper;
import com.interview.app.model.Bug;
import com.interview.app.model.Device;
import com.interview.app.model.Tester;
import com.interview.app.model.TesterDevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

@Configuration
public class DataConfiguration {

    private static final Logger log = LoggerFactory.getLogger(DataConfiguration.class);

    @Bean
    List<Device> devices() {
        try (InputStream inputStream = new ClassPathResource("csv/devices.csv").getInputStream()) {
            return CSVHelper.getFromFileCSV(inputStream, Device.class);
        } catch (IOException e) {
            log.error("Devices could not be loaded", e);
            return Collections.emptyList();
        }
    }

    @Bean
    Map<Integer, Set<Integer>> testerDevices() {
        try (InputStream inputStream = new ClassPathResource("csv/tester_device.csv").getInputStream()) {
            List<TesterDevice> testerDevices = CSVHelper.getFromFileCSV(inputStream, TesterDevice.class);
            return testerDevices.stream().collect(
                    Collectors.groupingBy(
                            TesterDevice::getTesterId,
                            Collectors.mapping(
                                    TesterDevice::getDeviceId,
                                    Collectors.toSet()
                            )
                    )
            );
        } catch (IOException e) {
            log.error("Tester device could not be loaded", e);
            return Collections.emptyMap();
        }
    }

    @Bean
    @DependsOn({"testerDevices"})
    List<Tester> testers(Map<Integer, Set<Integer>> testerDevices) {
        try (InputStream inputStream = new ClassPathResource("csv/testers.csv").getInputStream()) {
            List<Tester> testers = CSVHelper.getFromFileCSV(inputStream, Tester.class);
            testers.forEach(tester -> tester.setDeviceIds(testerDevices.get(tester.getId())));
            return testers;
        } catch (IOException e) {
            log.error("Testers could not be loaded", e);
            return Collections.emptyList();
        }
    }

    @Bean
    List<Bug> bugs() {
        try (InputStream inputStream = new ClassPathResource("csv/bugs.csv").getInputStream()) {
            return CSVHelper.getFromFileCSV(inputStream, Bug.class);
        } catch (IOException e) {
            log.error("Testers could not be loaded", e);
            return Collections.emptyList();
        }
    }
}