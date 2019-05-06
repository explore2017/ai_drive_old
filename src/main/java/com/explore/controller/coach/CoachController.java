package com.explore.controller.coach;


import com.explore.common.ServerResponse;
import com.explore.pojo.*;
import com.explore.service.ICoachService;
import com.explore.service.IManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coach")
public class CoachController {

    @Autowired
    ICoachService coachService;

    /**
     * 展现该教练当前所教未拿驾照的学员
     * @param coach
     * @return
     */
    @GetMapping("/showStudents")
    public ServerResponse<List<Student>> showStudents(Coach coach) {
        ServerResponse<List<Student>> serverResponse = coachService.getStudent(coach.getId());
        return serverResponse;
    }

    /**
     * 修改教练所属校区
     * @param coach
     * @return
     */
    @PutMapping("/reviseCampus")
    public ServerResponse reviseCampus(Coach coach, Integer campus_id) {
        coach.setCampusId(campus_id);
        ServerResponse serverResponse = coachService.reviseCampus(coach);
        return serverResponse;
    }

    /**
     * 教练查看所教所有学员考试信息
     * @return
     */
    @GetMapping("/searchExam")
    public ServerResponse<List<Exam>> searchExam(Student student) {
        ServerResponse<List<Exam>> serverResponse = coachService.searchExam(student.getId());
        return serverResponse;
    }

    /**
     * 退出所属校区
     * @param coach
     * @return
     */
    @DeleteMapping("/deleteCampus")
    public ServerResponse deleteCampus(Coach coach) {
        ServerResponse serverResponse = coachService.deleteCampus(coach);
        return serverResponse;
    }

    /**
     * 退出所属组织
     * @param coach
     * @return
     */
    @DeleteMapping("/deleteOrgan")
    public ServerResponse deleteOrgan(Coach coach) {
        ServerResponse serverResponse = coachService.deleteOrgan(coach);
        return serverResponse;
    }
}
