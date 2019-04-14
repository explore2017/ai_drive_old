package com.explore.dao;

import com.explore.pojo.Organ;

public interface OrganMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Organ record);

    int insertSelective(Organ record);

    Organ selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Organ record);

    int updateByPrimaryKey(Organ record);
}