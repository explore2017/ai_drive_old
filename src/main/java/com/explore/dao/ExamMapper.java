package com.explore.dao;

import com.explore.pojo.Exam;

import java.util.List;

public interface ExamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Exam record);

    int insertSelective(Exam record);

    Exam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);

    List<Exam> allExam();

    List<Exam> searchExam(Integer studentId);
}