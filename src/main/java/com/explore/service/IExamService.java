package com.explore.service;

import com.explore.common.ServerResponse;
import com.explore.pojo.Exam;
import com.explore.pojo.Student;

import java.util.List;

public interface IExamService {

    ServerResponse<List<Student>> searchStudent(Exam exam);

    ServerResponse<List<Student>> searchPass(Exam exam);

    ServerResponse deleteExam(Exam exam);
}
