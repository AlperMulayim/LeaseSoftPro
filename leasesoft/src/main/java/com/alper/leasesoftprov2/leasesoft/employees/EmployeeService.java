package com.alper.leasesoftprov2.leasesoft.employees;

import com.alper.leasesoftprov2.leasesoft.mappers.EmployeeMapper;
import com.alper.leasesoftprov2.leasesoft.mappers.dtos.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<EmployeeDTO> getAll(){
        EmployeeMapper mapper = new EmployeeMapper();
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}
