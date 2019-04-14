package com.explore.dao;

import com.explore.pojo.SubjectStudent;

public interface SubjectStudentMapper {
    int insert(SubjectStudent record);

    int insertSelective(SubjectStudent record);
}