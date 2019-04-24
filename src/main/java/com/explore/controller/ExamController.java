package com.explore.controller;

import com.explore.common.ServerResponse;
import com.explore.pojo.Campus;
import com.explore.pojo.Exam;
import com.explore.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    IExamService ExamService;

    /**
     * 查看该考试所有学员信息
     * @param exam
     * @return
     */
    @PostMapping("/searchStudent")
    public ServerResponse searchStudent(@RequestBody Exam exam) {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 查看该考试所有学员通过信息
     * @param exam
     * @return
     */
    @PostMapping("/searchPass")
    public ServerResponse searchPass(@RequestBody Exam exam) {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 删除考试
     * @param exam
     * @return
     */
    @DeleteMapping("/deleteExam")
    public ServerResponse deleteExam(Exam exam) {

        return ServerResponse.createBySuccessMessage("success");
    }
}
