package com.interview.app.controller;

import com.interview.app.model.Device;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class DeviceController {

    List<Device> devices;

    @GetMapping("/devices")
    public List<Device> getDevices() {
        return devices;
    }
}
