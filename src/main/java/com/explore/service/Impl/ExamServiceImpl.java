package com.explore.service.Impl;


import com.explore.common.ServerResponse;
import com.explore.dao.ExamMapper;
import com.explore.dao.StudentMapper;
import com.explore.pojo.Exam;
import com.explore.pojo.Student;
import com.explore.pojo.SubjectStudent;
import com.explore.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements IExamService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    ExamMapper examMapper;
    @Override
    public ServerResponse<List<Student>> searchStudent(Exam exam) {
        List<Student> students = studentMapper.searchStudentExam(exam.getId());
        return ServerResponse.createBySuccess(students);
    }

    @Override
    public ServerResponse<List<Student>> searchPass(Exam exam) {
        List<Student> students = studentMapper.searchPass(exam.getId());
        return ServerResponse.createBySuccess(students);
    }

    @Override
    public ServerResponse deleteExam(Exam exam) {
        int count = examMapper.deleteByPrimaryKey(exam.getId());
        if(count==1)
            return ServerResponse.createBySuccessMessage("删除考试成功");
        return ServerResponse.createByErrorMessage("删除考试失败");
    }
}
