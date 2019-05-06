package com.explore.service.Impl;


import com.explore.common.ServerResponse;
import com.explore.dao.CampusMapper;
import com.explore.dao.OrganMapper;
import com.explore.pojo.Campus;
import com.explore.pojo.Organ;
import com.explore.service.IOrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganServiceImpl implements IOrganService {

    @Autowired
    CampusMapper campusMapper;
    @Autowired
    OrganMapper organMapper;

    @Override
    public ServerResponse<List<Campus>> searchCampus(Organ organ) {
        List<Campus> campuses = campusMapper.searchCampusOrgan(organ.getId());
        return ServerResponse.createBySuccess(campuses);
    }

    @Override
    public ServerResponse deleteOrgan(Organ organ) {
        int count  = organMapper.deleteByPrimaryKey(organ.getId());
        if(count==1)
            return ServerResponse.createBySuccessMessage("删除组织成功");
        return ServerResponse.createByErrorMessage("删除组织失败");
    }
}
