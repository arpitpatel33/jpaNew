package com.example.jpaNew.repositories;

import com.example.jpaNew.entities.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MobileRepository extends JpaRepository<Mobile,Long> {
    List<Mobile> getByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId);
}
