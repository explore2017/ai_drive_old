package com.explore.dao;

import com.explore.pojo.Vehicle;

import java.util.List;

public interface VehicleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Vehicle record);

    int insertSelective(Vehicle record);

    Vehicle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Vehicle record);

    int updateByPrimaryKey(Vehicle record);

    List<Vehicle> searchVehicles(Integer compusId);

    List<Vehicle> showVehicles();
}