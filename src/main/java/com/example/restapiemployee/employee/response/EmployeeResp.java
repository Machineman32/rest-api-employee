package com.example.restapiemployee.employee.response;

import com.example.restapiemployee.employee.dao.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter @AllArgsConstructor
public class EmployeeResp {
    private String name;
    private long CNP;
    private LocalDate birthDate;
    private long ID;

    public EmployeeResp (EmployeeEntity employeeEntity) {
        this.name = employeeEntity.getName();
        this.CNP = employeeEntity.getCNP();
        this.birthDate = employeeEntity.getBirthDate();
        this.ID = employeeEntity.getId();
    }
}
