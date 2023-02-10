package com.example.jpaNew.repositories;

import com.example.jpaNew.entities.Society;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SocietyRepository extends JpaRepository <Society, Long> {


    Optional <Society> findById(Long id);

    public List<Society> findByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId);

    Society save(Society society);


}
