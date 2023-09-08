package com.alper.leasesoftprobe.vipservices.services;

import com.alper.leasesoftprobe.vipservices.entities.VipOperations;
import com.alper.leasesoftprobe.vipservices.repositories.VipOperationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VipOperationsService {

    @Autowired
    private VipOperationsRepository repository;

    public List<VipOperations>  getVipOperations(){
        return  repository.findAll();
    }
}
