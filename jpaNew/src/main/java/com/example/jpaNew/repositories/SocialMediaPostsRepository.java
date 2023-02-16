package com.example.jpaNew.repositories;


import com.example.jpaNew.entities.SocialMediaPosts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocialMediaPostsRepository extends JpaRepository<SocialMediaPosts, Long> {
    List<SocialMediaPosts> findByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId);

    String getMessage();
}
