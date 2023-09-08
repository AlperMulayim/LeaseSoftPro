package com.alper.leasesoftprov2.leasesoft.mappers;

import com.alper.leasesoftprov2.leasesoft.employees.Employee;
import com.alper.leasesoftprov2.leasesoft.mappers.dtos.EmployeeDTO;
import jakarta.transaction.NotSupportedException;

public class EmployeeMapper implements  IEntityMapper<Employee, EmployeeDTO> {
    @Override
    public EmployeeDTO toDTO(Employee employee) {
        return EmployeeDTO.builder()
                .name(employee.getName())
                .surname(employee.getSurname())
                .jobTitle(employee.getJobTitle())
                .build();
    }

    @Override
    public Employee toEntity(EmployeeDTO employeeDTO) throws NotSupportedException {
        throw  new NotSupportedException("Not Supported for Employee");
    }
}
