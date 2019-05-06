package com.explore.service;


import com.explore.common.ServerResponse;
import com.explore.pojo.Campus;
import com.explore.pojo.Organ;

import java.util.List;

public interface IOrganService {

    ServerResponse<List<Campus>> searchCampus(Organ organ);

    ServerResponse deleteOrgan(Organ organ);
}
