package com.explore.dao;

import com.explore.pojo.Student;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> unPassStudent(Integer id);

    Student showStudent(String name, String phone);

    List<Student> getAllStudent();

    List<Student> searchStudent(Integer campusId);

    List<Student> searchStudentExam(Integer examId);

    List<Student> searchPass(Integer examId);

    Student getStudentId(String name,String phone);
}