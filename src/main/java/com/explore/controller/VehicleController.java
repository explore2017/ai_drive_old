package com.explore.controller;

import com.explore.common.ServerResponse;
import com.explore.pojo.Exam;
import com.explore.pojo.Vehicle;
import com.explore.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    IVehicleService vehicleService;


    /**
     * 添加车辆
     * @param vehicle
     * @return
     */
    @PostMapping("/addVehicle")
    public ServerResponse addVehicle(@RequestBody Vehicle vehicle) {
        ServerResponse serverResponse = vehicleService.addVehicle(vehicle);
        return serverResponse;
    }

    /**
     * 展示所有车辆
     * @return
     */
    @GetMapping("/showVehicles")
    public ServerResponse<List<Vehicle>> showVehicles() {
        ServerResponse<List<Vehicle>> serverResponse = vehicleService.showVehicles();
        return serverResponse;
    }

    /**
     * 展示单个车辆
     * @param vehicle
     * @return
     */
    @PostMapping("/showVehicle")
    public ServerResponse showVehicle(@RequestBody Vehicle vehicle) {
        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 修改车辆
     * @param vehicle
     * @return
     */
    @PutMapping("/reviseVehicle")
    public ServerResponse reviseVehicle(Vehicle vehicle) {
        ServerResponse serverResponse = vehicleService.reviseVehicle(vehicle);
        return serverResponse;
    }

    /**
     * 删除车辆
     * @param vehicle
     * @return
     */
    @DeleteMapping("/deleteVehicle")
    public ServerResponse deleteVehicle(Vehicle vehicle) {
        ServerResponse serverResponse = vehicleService.deleteVehicle(vehicle);
        return serverResponse;
    }
}
