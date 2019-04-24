package com.explore.controller;

import com.explore.common.ServerResponse;
import com.explore.pojo.Campus;
import com.explore.pojo.Coach;
import com.explore.pojo.Exam;
import com.explore.pojo.Vehicle;
import com.explore.service.ICampusService;
import com.explore.service.IManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campus")
public class CampusController {

    @Autowired
    ICampusService CampusService;


    /**
     * 查看该校区所有学员基本信息
     * @param campus
     * @return
     */
    @PostMapping("/searchStudents")
    public ServerResponse searchStudents(@RequestBody Campus campus) {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 查看该校区所有教练基本信息
     * @param campus
     * @return
     */
    @PostMapping("/searchCoachs")
    public ServerResponse searchCoachs(@RequestBody Campus campus) {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 查看该校区所有车辆基本信息
     * @param campus
     * @return
     */
    @PostMapping("/searchVehicles")
    public ServerResponse searchVehicles(@RequestBody Campus campus) {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 查看该校区所有学员单次考试信息
     * @param campus
     * @param exam
     * @return
     */
    @PostMapping("/searchExam")
    public ServerResponse searchExam(@RequestBody Campus campus, Exam exam) {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 删除校区
     * @param campus
     * @return
     */
    @DeleteMapping("/deleteCampus")
    public ServerResponse deleteCampus(Campus campus) {

        return ServerResponse.createBySuccessMessage("success");
    }
}
