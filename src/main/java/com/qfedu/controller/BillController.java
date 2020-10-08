package com.qfedu.controller;

import com.github.pagehelper.PageInfo;
import com.qfedu.entity.BillInfo;
import com.qfedu.entity.BillRelease;
import com.qfedu.service.BillService;
import com.qfedu.util.JsonResult;
import com.qfedu.util.PageHelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * projectName: logistics
 * author: 张宁
 * time: 2020/10/7 13:49
 * description:
 */
@Controller
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;
    @ResponseBody
    @RequestMapping("/findNotRelease.do")
    public PageHelperUtil findNotRelease(Integer pageNum,Integer limit){
        List<BillInfo> list = billService.findNotRelease(pageNum, limit);
        PageInfo<BillInfo> pageInfo = new PageInfo<>(list);
        return PageHelperUtil.success(pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping("/findByPage.do")
    @ResponseBody
    public PageHelperUtil findByPage(Integer pageNum,Integer limit){
        List<BillInfo> list = billService.findByPage(pageNum, limit);
        PageInfo<BillInfo> pageInfo = new PageInfo<>(list);
        return PageHelperUtil.success(pageInfo.getTotal(),pageInfo.getList());
    }
    @RequestMapping("/addRelease.do")
    @ResponseBody
    public JsonResult addRelease(BillRelease billRelease){
        JsonResult release = billService.addRelease(billRelease);
        return release;
    }
}
