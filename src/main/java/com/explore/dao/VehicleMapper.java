package com.explore.dao;

import com.explore.pojo.Vehicle;

public interface VehicleMapper {
    int insert(Vehicle record);

    int insertSelective(Vehicle record);
}