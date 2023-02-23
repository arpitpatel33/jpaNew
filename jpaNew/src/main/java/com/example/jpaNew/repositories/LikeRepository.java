package com.example.jpaNew.repositories;

import com.example.jpaNew.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> getByIdGreaterThanEqualAndLessThanEqual(Long startId, Long endId);

    Like getBySource(String source);
}
