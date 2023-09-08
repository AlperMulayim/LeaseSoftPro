package com.alper.leasesoftprobe.buildings.repositories;

import com.alper.leasesoftprobe.buildings.entities.BuildingAdress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingAdressRepository extends JpaRepository<BuildingAdress,Integer> {
    List<BuildingAdress> findAll();
}
