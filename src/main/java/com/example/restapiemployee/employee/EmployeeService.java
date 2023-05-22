package com.example.restapiemployee.employee;

import com.example.restapiemployee.employee.dao.EmployeeDao;
import com.example.restapiemployee.employee.dao.EmployeeEntity;
import com.example.restapiemployee.employee.request.EmployeeReq;
import com.example.restapiemployee.employee.response.EmployeeResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    public EmployeeResp createEmployee(EmployeeReq emp) {
        EmployeeEntity employeeEntity = new EmployeeEntity(emp.getName(), emp.getCNP(), emp.getBirthDate());
        employeeDao.save(employeeEntity);

        return new EmployeeResp(employeeEntity);
    }

    public List<EmployeeResp> getAllEmployees () {
        List<EmployeeResp> employeesRespList = new ArrayList<>();
        for(EmployeeEntity employeeEntity : this.employeeDao.findAll()) {
            employeesRespList.add(new EmployeeResp(employeeEntity));
        }

        return employeesRespList;
    }

    public EmployeeResp getEmployeeById (long id) {
        Optional<EmployeeEntity> employee = this.employeeDao.findById(id);

        EmployeeResp employeeResp = null;

        if(employee.isPresent()) {
            employeeResp = new EmployeeResp(employee.get());
        }

        return employeeResp;
    }

    public boolean deleteEmployeeById (long id) {
        if(this.getEmployeeById(id) != null) {
            this.employeeDao.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public EmployeeResp updateEmployeeById (long id, EmployeeReq employeeReq) {
        EmployeeEntity employeeEntity = this.employeeDao.findById(id).get();

        employeeEntity.setName(employeeReq.getName());
        employeeEntity.setCNP(employeeReq.getCNP());
        employeeEntity.setBirthDate(employeeReq.getBirthDate());

        this.employeeDao.save(employeeEntity);

        return new EmployeeResp(employeeEntity);
    }
}
