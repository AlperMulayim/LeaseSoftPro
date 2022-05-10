package com.alper.leasesoftprobe.buildings.services;

import com.alper.leasesoftprobe.buildings.entities.Floor;
import com.alper.leasesoftprobe.buildings.entities.LeasProBuilding;
import com.alper.leasesoftprobe.buildings.repositories.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FloorService {
    @Autowired
    private FloorRepository repository;
    @Autowired
    private LeasProBuildingService buildingService;

    public Floor saveFloor(Integer buildingId, Floor floor) throws Exception {
        Optional<LeasProBuilding> building = buildingService.getBuilding(buildingId);
        if (building.isPresent()) {
            List<Floor> floorList = building.get().getFloors().stream()
                    .filter(f -> f.getFloorNum() == floor.getFloorNum()).collect(Collectors.toList());

            if (floorList.isEmpty()) {
                floor.setBuildingId(buildingId);
                building.get().getFloors().add(floor);
                return repository.save(floor);
            }
            else{
                throw new Exception("Floor already exist for building");
            }
        } else {
            throw new Exception("Building not found for floor");
        }
    }

}
