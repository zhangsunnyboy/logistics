package com.qfedu.service;

import com.qfedu.entity.BillInfo;
import com.qfedu.entity.BillRelease;
import com.qfedu.util.JsonResult;

import java.util.List;

public interface BillService {
    List<BillInfo> findNotRelease(Integer pageNum, Integer limit);
    List<BillInfo> findByPage(Integer pageNum, Integer limit);
    JsonResult addRelease(BillRelease billRelease);
}
