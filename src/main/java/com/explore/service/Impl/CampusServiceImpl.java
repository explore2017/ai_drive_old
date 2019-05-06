package com.explore.service.Impl;

import com.explore.common.ServerResponse;
import com.explore.dao.CampusMapper;
import com.explore.dao.CoachMapper;
import com.explore.dao.StudentMapper;
import com.explore.dao.VehicleMapper;
import com.explore.pojo.Campus;
import com.explore.pojo.Coach;
import com.explore.pojo.Student;
import com.explore.pojo.Vehicle;
import com.explore.service.ICampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampusServiceImpl implements ICampusService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CoachMapper coachMapper;
    @Autowired
    VehicleMapper vehicleMapper;
    @Autowired
    CampusMapper campusMapper;

    @Override
    public ServerResponse<List<Student>> searchStudents(Campus campus) {
        List<Student> students = studentMapper.searchStudent(campus.getId());
        return ServerResponse.createBySuccess(students);
    }

    @Override
    public ServerResponse<List<Coach>> searchCoaches(Campus campus) {
        List<Coach> coaches = coachMapper.searchCoaches(campus.getId());
        return ServerResponse.createBySuccess(coaches);
    }

    @Override
    public ServerResponse<List<Vehicle>> searchVehicles(Campus campus) {
        List<Vehicle> vehicles = vehicleMapper.searchVehicles(campus.getId());
        return ServerResponse.createBySuccess(vehicles);
    }

    @Override
    public ServerResponse deleteCampus(Campus campus) {
        int count = campusMapper.deleteByPrimaryKey(campus.getId());
        if(count==1)
            return ServerResponse.createBySuccessMessage("删除成功");
        return ServerResponse.createByErrorMessage("删除失败");
    }
}
