package com.explore.service;

import com.explore.common.ServerResponse;
import com.explore.pojo.Campus;
import com.explore.pojo.Coach;
import com.explore.pojo.Student;
import com.explore.pojo.Vehicle;

import java.util.List;

public interface ICampusService {

    ServerResponse<List<Student>> searchStudents(Campus campus);

    ServerResponse<List<Coach>> searchCoaches(Campus campus);

    ServerResponse<List<Vehicle>> searchVehicles(Campus campus);

    ServerResponse deleteCampus(Campus campus);
}
