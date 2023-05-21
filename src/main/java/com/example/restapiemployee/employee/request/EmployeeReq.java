package com.example.restapiemployee.employee.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter @Getter @AllArgsConstructor @ToString
public class EmployeeReq {
    private String name;
    private long CNP;
    private LocalDate birthDate;
}
