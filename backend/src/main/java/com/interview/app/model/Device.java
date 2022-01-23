package com.interview.app.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class Device {

    @CsvBindByName(column = "deviceId")
    private int id;

    @CsvBindByName(column = "description")
    private String description;
}
