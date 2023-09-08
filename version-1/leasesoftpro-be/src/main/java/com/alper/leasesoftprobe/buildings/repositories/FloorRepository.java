package com.alper.leasesoftprobe.buildings.repositories;

import com.alper.leasesoftprobe.buildings.entities.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends JpaRepository<Floor,Integer> {
}
