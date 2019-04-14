package com.explore.dao;

import com.explore.pojo.Coach;

public interface CoachMapper {
    int insert(Coach record);

    int insertSelective(Coach record);
}