package com.explore.dao;

import com.explore.pojo.Student;

public interface StudentMapper {
    int insert(Student record);

    int insertSelective(Student record);
}