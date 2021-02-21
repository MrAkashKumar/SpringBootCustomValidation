package com.akash.customValidation.controller;

import com.akash.customValidation.dto.Employee;
import com.akash.customValidation.validations.constraint.ValidEmployee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @PostMapping(value = "/api/v1/employee")
    public ResponseEntity<Object> validateEmployee(@ValidEmployee @RequestBody Employee employee){
        return new ResponseEntity<>("Success",HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/api/v1/validate")
    public ResponseEntity<Object> validateEmployeeDemo(@ValidEmployee @RequestBody Employee employee){
        System.out.println(employee);
        return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
    }
}
