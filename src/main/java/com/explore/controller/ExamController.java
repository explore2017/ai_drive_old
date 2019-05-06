package com.explore.controller;

import com.explore.common.ServerResponse;
import com.explore.pojo.Campus;
import com.explore.pojo.Exam;
import com.explore.pojo.Student;
import com.explore.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    IExamService examService;

    /**
     * 查看该考试所有学员信息
     * @param exam
     * @return
     */
    @GetMapping("/searchStudent")
    public ServerResponse<List<Student>> searchStudent(Exam exam) {
        ServerResponse<List<Student>> serverResponse = examService.searchStudent(exam);
        return serverResponse;
    }

    /**
     * 查看该考试所有学员通过信息
     * @param exam
     * @return
     */
    @GetMapping("/searchPass")
    public ServerResponse<List<Student>> searchPass( Exam exam) {
        ServerResponse<List<Student>> serverResponse = examService.searchPass(exam);
        return serverResponse;
    }

    /**
     * 删除考试
     * @param exam
     * @return
     */
    @DeleteMapping("/deleteExam")
    public ServerResponse deleteExam(Exam exam) {
        ServerResponse serverResponse = examService.deleteExam(exam);
        return serverResponse;
    }
}
