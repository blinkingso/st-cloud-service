package com.shitu.cloud.mybatis.mapper;

import com.shitu.cloud.mybatis.entity.Test;

import java.util.List;

public interface TestMapper {

    Test selectOne(Long id);

    List<Test> selectList();
}
