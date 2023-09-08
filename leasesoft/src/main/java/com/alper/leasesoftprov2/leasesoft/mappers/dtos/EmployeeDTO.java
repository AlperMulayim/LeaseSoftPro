package com.alper.leasesoftprov2.leasesoft.mappers.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmployeeDTO {
    private String name;
    private String  surname;
    private String jobTitle;

}
