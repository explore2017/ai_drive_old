package com.explore.service.Impl;


import com.explore.common.ServerResponse;
import com.explore.dao.*;
import com.explore.pojo.Coach;
import com.explore.pojo.Exam;
import com.explore.pojo.Student;
import com.explore.service.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public class CoachServiceImpl implements ICoachService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CampusMapper campusMapper;
    @Autowired
    CoachMapper coachMapper;
    @Autowired
    SubjectStudentMapper subjectStudentMapper;
    @Autowired
    ExamMapper examMapper;

    @Override
    public ServerResponse<List<Student>> getStudent(Integer id) {
        return ServerResponse.createBySuccess(studentMapper.unPassStudent(id));
    }

    @Override
    public ServerResponse reviseCampus(Coach coach) {
        Date update_time = new Date();
        coach.setUpdateTime(update_time);
        int count = coachMapper.updateByPrimaryKeySelective(coach);
        if(count == 1)
            return ServerResponse.createBySuccessMessage("修改成功");
        return ServerResponse.createByErrorMessage("修改失败");
    }

    @Override
    public ServerResponse<List<Exam>> searchExam(Integer studentId) {
        List<Exam> exam =examMapper .searchExam(studentId);
        if(exam==null)
            return ServerResponse.createByErrorMessage("查询失败");
        return ServerResponse.createBySuccessMessage("查询成功",exam);
    }

    @Override
    public ServerResponse deleteCampus(Coach coach) {
        Date update_time = new Date();
        coach.setUpdateTime(update_time);
        coach.setCampusId(0);
        int count = coachMapper.updateByPrimaryKeySelective(coach);
        if(count==1)
            return ServerResponse.createBySuccessMessage("退出校区成功");
        return ServerResponse.createByErrorMessage("退出校区失败");
    }

    @Override
    public ServerResponse deleteOrgan(Coach coach) {
        Date update_time = new Date();
        coach.setUpdateTime(update_time);
        coach.setOrganId(0);
        int count = coachMapper.updateByPrimaryKeySelective(coach);
        if(count==1)
            return ServerResponse.createBySuccessMessage("退出组织成功");
        return ServerResponse.createByErrorMessage("退出组织失败");
    }

}
