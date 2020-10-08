package com.qfedu.dao;

import com.qfedu.entity.BillRelease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillReleaseRepository extends JpaRepository<BillRelease,Long> {
    BillRelease save(BillRelease billRelease);
}
