package com.explore.controller.student;

import com.explore.common.ServerResponse;
import com.explore.pojo.*;
import com.explore.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService studentService;

    /**
     * 学员登陆(包含是否拿到驾照)
     * @return
     */
    @PostMapping("/login")
    public ServerResponse<Student> showStudents(@RequestBody String name,String phone) {
        ServerResponse<Student> serverResponse = studentService.showStudent(name,phone);
        return serverResponse;
    }

    /**
     * 展现该学员所有考试信息
     * @param student
     * @return
     */
    @GetMapping("/showExams")
    public ServerResponse<List<Exam>> showExams(Student student) {
        ServerResponse<List<Exam>> serverResponse = studentService.showExams(student);
        return serverResponse;
    }


    /**
     * 学员归入某个教练
     * @param student
     * @param coach
     * @return
     */
    @PutMapping("/addCoach")
    public ServerResponse addCoach(Student student, Coach coach) {
        ServerResponse serverResponse = studentService.addCoach(student,coach);
        return serverResponse;
    }

    /**
     * 修改学员所属校区
     * @param student
     * @return
     */
    @PutMapping("/reviseCampus")
    public ServerResponse reviseCampus(Student student, int  campus_id) {
        ServerResponse serverResponse = studentService.reviseCampus(student,campus_id);
        return serverResponse;
    }

    /**
     * 学员报考考试
     * @param student
     * @param exam
     * @return
     */
    @PutMapping("/addExam")
    public ServerResponse addExam(Student student, Exam exam) {
        ServerResponse serverResponse = studentService.addExam(student,exam);
        return serverResponse;
    }

    /**
     * 学员查看个人考试信息
     * @param student
     * @return
     */
    @PostMapping("/searchExam")
    public ServerResponse<List<Exam>> searchExam( Student student) {
        ServerResponse<List<Exam>> serverResponse = studentService.searchExam(student);
        return serverResponse;
    }

    /**
     * 退出某个教练教学
     * @param student
     * @return
     */
    @DeleteMapping("/deleteStudent")
    public ServerResponse deleteStudent(Student student) {
        ServerResponse serverResponse=studentService.deleteStudent(student);
        return serverResponse;
    }
}
