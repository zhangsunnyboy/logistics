package com.qfedu.dao;

import com.qfedu.entity.FunctionWithGroup;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GroupDao {
    List<FunctionWithGroup> selectFunc(String loginId);
}
