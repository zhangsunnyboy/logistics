package com.qfedu.controller;

import com.qfedu.service.GroupService;
import com.qfedu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * projectName: logistics
 * author: 张宁
 * time: 2020/10/6 19:01
 * description:
 */
@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private GroupService groupService;
    @RequestMapping("/selectFunc.do")
    public JsonResult selectFunc(String loginId){
        System.out.println("============");
        JsonResult jsonResult = groupService.selectFunc(loginId);
        return jsonResult;
    }
}
