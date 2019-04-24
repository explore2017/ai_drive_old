package com.explore.controller;

import com.explore.common.ServerResponse;
import com.explore.pojo.Exam;
import com.explore.pojo.Organ;
import com.explore.service.IOrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/organ")
public class OrganController {

    @Autowired
    IOrganService OrganService;


    /**
     * 查看该组织所有校区基本信息
     * @param organ
     * @return
     */
    @PostMapping("/searchCampus")
    public ServerResponse searchCampus(@RequestBody Organ organ) {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 删除组织
     * @param organ
     * @return
     */
    @DeleteMapping("/deleteOrgan")
    public ServerResponse deleteOrgan(Organ organ) {

        return ServerResponse.createBySuccessMessage("success");
    }
}
