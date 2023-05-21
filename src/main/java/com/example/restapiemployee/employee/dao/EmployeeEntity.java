package com.example.restapiemployee.employee.dao;

import jakarta.persistence.*;

import java.time.*;

@Entity
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @Column (name = "employeeId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private long CNP;

    @Column
    private LocalDate birthDate;

    public EmployeeEntity(String name, long CNP, LocalDate birthDate) {
        this.name = name;
        this.CNP = CNP;
        this.birthDate = birthDate;
    }

    public EmployeeEntity () {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCNP() {
        return CNP;
    }

    public void setCNP(long CNP) {
        this.CNP = CNP;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
