package com.explore.dao;

import com.explore.pojo.Source;

public interface SourceMapper {
    int insert(Source record);

    int insertSelective(Source record);
}