package com.alper.leasesoftprov2.leasesoft.employees;

import com.alper.leasesoftprov2.leasesoft.mappers.dtos.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("")
    List<EmployeeDTO> getAllEmployees(){
        return service.getAll();
    }
}
