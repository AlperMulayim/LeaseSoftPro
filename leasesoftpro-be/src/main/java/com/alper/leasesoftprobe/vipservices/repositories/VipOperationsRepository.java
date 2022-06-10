package com.alper.leasesoftprobe.vipservices.repositories;

import com.alper.leasesoftprobe.vipservices.entities.VipOperations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VipOperationsRepository extends JpaRepository<VipOperations, Integer> {
}
