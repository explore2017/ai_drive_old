package com.explore.dao;

import com.explore.pojo.Exam;

public interface ExamMapper {
    int insert(Exam record);

    int insertSelective(Exam record);
}