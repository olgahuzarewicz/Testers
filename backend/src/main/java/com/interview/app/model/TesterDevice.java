package com.interview.app.model;

import com.opencsv.bean.CsvBindByName;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TesterDevice {

    @CsvBindByName(column = "testerId")
    int testerId;

    @CsvBindByName(column = "deviceId")
    int deviceId;
}
