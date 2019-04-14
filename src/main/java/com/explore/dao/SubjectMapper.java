package com.explore.dao;

import com.explore.pojo.Subject;

public interface SubjectMapper {
    int insert(Subject record);

    int insertSelective(Subject record);
}