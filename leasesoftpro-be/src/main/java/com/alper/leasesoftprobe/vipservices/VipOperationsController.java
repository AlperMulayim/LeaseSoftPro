package com.alper.leasesoftprobe.vipservices;

import com.alper.leasesoftprobe.vipservices.entities.VipOperations;
import com.alper.leasesoftprobe.vipservices.services.VipOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("api/v1/services")
public class VipOperationsController {

    @Autowired
    private VipOperationsService operationsService;

    @GetMapping("")
    public List<VipOperations> getAllServices() {
       return  operationsService.getVipOperations();
    }
}
