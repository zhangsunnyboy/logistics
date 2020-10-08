package com.qfedu.dao;
import com.qfedu.entity.BillInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * projectName: logistics
 * author: 张宁
 * time: 2020/10/7 10:52
 * description:
 */
@Repository
public interface BillInfoDao extends JpaRepository<BillInfo,Long> {
    List<BillInfo> findAllByBillState(String billState);
    List<BillInfo> findAll();
    BillInfo findByBillCode(String billCode);
    BillInfo save(BillInfo billInfo);
}
