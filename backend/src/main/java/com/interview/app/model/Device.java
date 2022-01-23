package com.interview.app.model;

import com.opencsv.bean.CsvBindByName;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Device {

    @CsvBindByName(column = "deviceId")
    int id;

    @CsvBindByName(column = "description")
    String description;
}
