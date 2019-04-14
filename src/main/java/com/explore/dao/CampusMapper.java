package com.explore.dao;

import com.explore.pojo.Campus;

public interface CampusMapper {
    int insert(Campus record);

    int insertSelective(Campus record);
}