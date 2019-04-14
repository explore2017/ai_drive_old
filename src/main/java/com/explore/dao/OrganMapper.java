package com.explore.dao;

import com.explore.pojo.Organ;

public interface OrganMapper {
    int insert(Organ record);

    int insertSelective(Organ record);
}