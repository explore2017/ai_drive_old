package com.explore.controller;

import com.explore.common.ServerResponse;
import com.explore.pojo.Campus;
import com.explore.pojo.Exam;
import com.explore.pojo.Organ;
import com.explore.service.IOrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organ")
public class OrganController {

    @Autowired
    IOrganService organService;


    /**
     * 查看该组织所有校区基本信息
     * @param organ
     * @return
     */
    @GetMapping("/searchCampus")
    public ServerResponse<List<Campus>> searchCampus(Organ organ) {
        ServerResponse<List<Campus>> serverResponse = organService.searchCampus(organ);
        return serverResponse;
    }

    /**
     * 删除组织
     * @param organ
     * @return
     */
    @DeleteMapping("/deleteOrgan")
    public ServerResponse deleteOrgan(Organ organ) {
        ServerResponse serverResponse = organService.deleteOrgan(organ);
        return ServerResponse.createBySuccessMessage("success");
    }
}
