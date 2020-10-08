package com.qfedu.service.impl;

import com.qfedu.dao.GroupDao;
import com.qfedu.entity.FunctionWithGroup;
import com.qfedu.service.GroupService;
import com.qfedu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * projectName: logistics
 * author: 张宁
 * time: 2020/10/6 18:52
 * description:
 */
@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupDao groupDao;
    @Override
    public JsonResult selectFunc(String loginId) {
        List<FunctionWithGroup> functionWithGroups = groupDao.selectFunc(loginId);
        if(functionWithGroups ==null){
            throw new RuntimeException("信息为空");
        }
        return new JsonResult(1,functionWithGroups);
    }
}
