package com.explore.service.Impl;

import com.explore.common.ServerResponse;
import com.explore.dao.*;
import com.explore.pojo.*;
import com.explore.service.IManageService;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ManageServiceImpl implements IManageService {
    @Autowired
    StaffMapper staffMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    ExamMapper examMapper;
    @Autowired
    SubjectMapper subjectMapper;
    @Autowired
    SubjectStudentMapper subjectStudentMapper;
    @Autowired
    CoachMapper coachMapper;

    @Override
    public ServerResponse<Staff> login(String username, String password) {
        Staff staff = staffMapper.login(username,password);
        if(staff==null)
            return ServerResponse.createByErrorMessage("账号密码错误");
        staff.setPassword("");
        return ServerResponse.createBySuccessMessage("登陆成功",staff);
    }

    @Override
    public ServerResponse revisePassword(String name, String oldPassword, String newPassword) {
        Staff staff = staffMapper.login(name, oldPassword);
        if (staff == null) {
            return ServerResponse.createByErrorMessage("密码错误");
        }
        staff.setPassword(newPassword);
        int count = staffMapper.updateByPrimaryKey(staff);
        if (count == 1) {
            return ServerResponse.createBySuccessMessage("修改密码成功");
        }
        return ServerResponse.createByErrorMessage("修改失败");
    }

    @Override
    public ServerResponse<List<Student>> Students() {
        return ServerResponse.createBySuccess(studentMapper.getAllStudent());
    }

    @Override
    public ServerResponse addStudent(Student student) {
        student.setStatus(0);
        int count = studentMapper.insert(student);
        List<Subject> subjects = subjectMapper.allSubject();
       Student student1 = studentMapper.getStudentId(student.getName(),student.getPhone());
        SubjectStudent subjectStudent = new SubjectStudent();
        subjectStudent.setStudentId(student1.getId());
        subjectStudent.setExamId(-1);
        subjectStudent.setCount(0);
        subjectStudent.setStatus(0);
        if(count==1)
        {
            for(int i=0;i< subjects.size();i++)
            {
                subjectStudent.setSubjectId(subjects.get(i).getId());
                subjectStudentMapper.insertSelective(subjectStudent);
            }
            return ServerResponse.createBySuccessMessage("学生增加成功");
        }
        return ServerResponse.createByErrorMessage("学生增加失败");
    }

    @Override
    public ServerResponse outStudent(Integer id) {
        int count = studentMapper.deleteByPrimaryKey(id);
        if(count==1)
            return ServerResponse.createBySuccessMessage("学生删除成功");
        return ServerResponse.createByErrorMessage("学生删除失败");
    }

    @Override
    public ServerResponse reviseStudent(Student student) {
        int count = studentMapper.updateByPrimaryKeySelective(student);
        if(count==1)
            return ServerResponse.createBySuccessMessage("学生修改成功");
        return ServerResponse.createByErrorMessage("学生修改失败");
    }

    @Override
    public ServerResponse<List<Coach>> Coachs() {
        return ServerResponse.createBySuccess(coachMapper.getAllCoach());
    }

    @Override
    public ServerResponse addCoach(Coach coach) {
        Long job_id = Long.valueOf(coachMapper.maxJob_id())+1;
        coach.setJobId(job_id.toString());
        Date creat_time = new Date();
        coach.setCreateTime(creat_time);
        coach.setUpdateTime(creat_time);
        int count = coachMapper.insert(coach);
        if(count==1)
            return ServerResponse.createBySuccessMessage("教练增加成功");
        return ServerResponse.createByErrorMessage("教练增加失败");
    }

    @Override
    public ServerResponse outCoach(Integer id) {
        int count=coachMapper.deleteByPrimaryKey(id);
        if(count==1)
            return ServerResponse.createBySuccessMessage("教练删除成功");
        return  ServerResponse.createByErrorMessage("教练删除失败");
    }

    @Override
    public ServerResponse reviseCoach(Coach coach) {
        Date update_time = new Date();
        coach.setUpdateTime(update_time);
        int count = coachMapper.updateByPrimaryKeySelective(coach);
        if(count==1)
            return ServerResponse.createBySuccessMessage("教练修改成功");
        return ServerResponse.createByErrorMessage("教练修改失败");
    }
}
