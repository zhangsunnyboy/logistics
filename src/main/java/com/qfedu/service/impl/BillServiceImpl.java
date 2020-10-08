package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.BillInfoDao;
import com.qfedu.dao.BillReleaseRepository;
import com.qfedu.entity.BillInfo;
import com.qfedu.entity.BillRelease;
import com.qfedu.service.BillService;
import com.qfedu.util.JsonResult;
import com.qfedu.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * projectName: logistics
 * author: 张宁
 * time: 2020/10/7 11:23
 * description:
 */
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillInfoDao billInfoDao;
    @Autowired
    private BillReleaseRepository billReleaseRepository;

    @Override
    public List<BillInfo> findNotRelease(Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<BillInfo> list = billInfoDao.findAllByBillState(StrUtil.BILL_UN_RELEASE);
        System.out.println("list = " + list);
        return list;
    }

    @Override
    public List<BillInfo> findByPage(Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum,limit);
        List<BillInfo> list = billInfoDao.findAll();
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult addRelease(BillRelease billRelease) {
        //查询票据信息
        BillInfo bill = billInfoDao.findByBillCode(billRelease.getBillCode());
        //将票据分发信息的type设置上
        billRelease.setBillType(bill.getBillType());
        //保存票据分发信息
        BillRelease brelease = billReleaseRepository.save(billRelease);
        if (brelease == null) {
            return new JsonResult(0, "添加失败");
        }
        //改变原票据信息的状态
        bill.setBillState(StrUtil.BILL_UN_SEND);
        billInfoDao.save(bill);
   return new JsonResult(1,"成功");
    }


}
