package com.interview.app.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class Tester {

    @CsvBindByName(column = "testerId")
    private int id;

    @CsvBindByName(column = "firstName")
    private String firstName;

    @CsvBindByName(column = "lastName")
    private String lastName;

    @CsvBindByName(column = "country")
    private String country;

    @CsvBindByName(column = "lastLogin")
    private String lastLogin;
}
