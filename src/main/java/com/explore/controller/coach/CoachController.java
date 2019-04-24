package com.explore.controller.coach;


import com.explore.common.ServerResponse;
import com.explore.pojo.Campus;
import com.explore.pojo.Coach;
import com.explore.pojo.Exam;
import com.explore.pojo.Organ;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coach")
public class CoachController {


    /**
     * 展现该教练当前所教未拿驾照的学员
     * @param coach
     * @return
     */
    @PostMapping("/showStudents")
    public ServerResponse showStudents(@RequestBody Coach coach) {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 修改教练所属校区
     * @param coach
     * @return
     */
    @PostMapping("/reviseCampus")
    public ServerResponse reviseCampus(@RequestBody Coach coach, Campus campus) {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 教练查看所教所有学员考试信息
     * @param coach
     * @param exam
     * @return
     */
    @PostMapping("/searchExam")
    public ServerResponse searchExam(@RequestBody Coach coach, Exam exam) {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 退出所属校区
     * @param coach
     * @param campus
     * @return
     */
    @DeleteMapping("/deleteCampus")
    public ServerResponse deleteCampus(Coach coach, Campus campus) {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 退出所属组织
     * @param coach
     * @param organ
     * @return
     */
    @DeleteMapping("/deleteOrgan")
    public ServerResponse deleteOrgan(Coach coach, Organ organ) {

        return ServerResponse.createBySuccessMessage("success");
    }
}
