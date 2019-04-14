package com.explore.dao;

import com.explore.pojo.Staff;

public interface StaffMapper {
    int insert(Staff record);

    int insertSelective(Staff record);
}