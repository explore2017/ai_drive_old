package com.explore.service;


import com.explore.common.ServerResponse;
import com.explore.pojo.Coach;
import com.explore.pojo.Exam;
import com.explore.pojo.Student;

import java.util.List;

public interface IStudentService {

    ServerResponse<Student> showStudent(String name, String phone);

    ServerResponse<List<Exam>> searchExam(Student student);

    ServerResponse addCoach(Student student, Coach coach);

    ServerResponse reviseCampus(Student student, int campus_id);

    ServerResponse addExam(Student student, Exam exam);

    ServerResponse<List<Exam>> showExams(Student student);

    ServerResponse deleteStudent(Student student);
}
