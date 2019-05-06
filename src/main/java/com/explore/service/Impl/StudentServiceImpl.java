package com.explore.service.Impl;


import com.explore.common.ServerResponse;
import com.explore.dao.ExamMapper;
import com.explore.dao.StudentMapper;
import com.explore.dao.SubjectStudentMapper;
import com.explore.pojo.Coach;
import com.explore.pojo.Exam;
import com.explore.pojo.Student;
import com.explore.pojo.SubjectStudent;
import com.explore.service.ICoachService;
import com.explore.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    SubjectStudentMapper subjectStudentMapper;
    @Autowired
    ExamMapper examMapper;

    @Override
    public ServerResponse<Student> showStudent(String name, String phone) {
        Student student = studentMapper.showStudent(name,phone);
        if(student==null)
            return ServerResponse.createByErrorMessage("查找失败");
        return ServerResponse.createBySuccessMessage("查找成功",student);
    }

    @Override
    public ServerResponse<List<Exam>> searchExam(Student student) {
        List<Exam> nowExam = examMapper.searchExam(student.getId());
        if(nowExam==null)
            return ServerResponse.createByErrorMessage("现在没有考试");
        return ServerResponse.createBySuccessMessage("现在有考试",nowExam);
    }

    @Override
    public ServerResponse addCoach(Student student, Coach coach) {
        student.setCoachId(coach.getId());
        student.setCampusId(coach.getCampusId());
        int count = studentMapper.updateByPrimaryKeySelective(student);
        if(count==1)
            return ServerResponse.createBySuccessMessage("归入教练成功");
        return ServerResponse.createByErrorMessage("归入教练失败");
    }

    @Override
    public ServerResponse reviseCampus(Student student, int campus_id) {
        student.setCampusId(campus_id);
        int count = studentMapper.updateByPrimaryKeySelective(student);
        if(count==1)
            return ServerResponse.createBySuccessMessage("改变校区成功");
        return ServerResponse.createByErrorMessage("改变校区失败");
    }

    @Override
    public ServerResponse addExam(Student student, Exam exam) {
        int count=-1;
        List<SubjectStudent> subjectStudents = subjectStudentMapper.showStudentState(student.getId());
        for(int i=0;i<subjectStudents.size();i++)
        {
            if(subjectStudents.get(i).getExamId()==exam.getId())
                count=i;
        }
        if(count!=-1)
        {
            SubjectStudent subjectStudent = subjectStudents.get(count);
            subjectStudent.setExamId(exam.getId());
            return ServerResponse.createBySuccessMessage("增加考试成功");
        }
        return ServerResponse.createByErrorMessage("增加考试失败");
    }

    @Override
    public ServerResponse<List<Exam>> showExams(Student student) {
        List<SubjectStudent> subjectStudents = subjectStudentMapper.showStudentState(student.getId());
        List<Exam> exams = null;
        for(int i=0;i<subjectStudents.size();i++)
        {
            exams.add(examMapper.selectByPrimaryKey(subjectStudents.get(i).getExamId()));
        }
        return ServerResponse.createBySuccessMessage("查询成功",exams);
    }

    @Override
    public ServerResponse deleteStudent(Student student) {
        student.setCoachId(-1);
        int count = studentMapper.updateByPrimaryKeySelective(student);
        if(count==1)
            return ServerResponse.createBySuccessMessage("退出教练成功");
        return ServerResponse.createByErrorMessage("退出教练失败");
    }
}
