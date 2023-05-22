package com.example.restapiemployee.employee;

import com.example.restapiemployee.employee.request.EmployeeReq;
import com.example.restapiemployee.employee.response.EmployeeResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")

public class RestControllerEmployee {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employees")
    public ResponseEntity<EmployeeResp> createEmployee (@RequestBody EmployeeReq emp) {
        return ResponseEntity.ok(employeeService.createEmployee(emp));
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<EmployeeResp> getEmployee (@PathVariable long employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeResp>> getEmployees () {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable long employeeId) {
        return ResponseEntity.ok(employeeService.deleteEmployeeById(employeeId));
    }

    @PutMapping("/employees/{employeeId}")
    public ResponseEntity<EmployeeResp> updateEmployee (@PathVariable long employeeId, @RequestBody EmployeeReq updatedEmployee) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, updatedEmployee));
    }
}
