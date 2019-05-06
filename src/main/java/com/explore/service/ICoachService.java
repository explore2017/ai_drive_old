package com.explore.service;


import com.explore.common.ServerResponse;
import com.explore.pojo.Coach;
import com.explore.pojo.Exam;
import com.explore.pojo.Student;

import java.util.List;

public interface ICoachService {

    ServerResponse<List<Student>> getStudent(Integer id);

    ServerResponse reviseCampus(Coach coach);

    ServerResponse<List<Exam>> searchExam(Integer studentId);

    ServerResponse deleteCampus(Coach coach);

    ServerResponse deleteOrgan(Coach coach);
}
