package com.example.jpaNew.repositories;

import com.example.jpaNew.entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {
    Comments findByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId);

    Comments findByComment(Comments comments);
}
