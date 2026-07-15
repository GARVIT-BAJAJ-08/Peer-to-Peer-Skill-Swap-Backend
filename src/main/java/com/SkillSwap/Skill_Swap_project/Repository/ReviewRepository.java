package com.SkillSwap.Skill_Swap_project.Repository;

import com.SkillSwap.Skill_Swap_project.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByReviewerId(Long reviewerId);

    List<Review> findByReviewedUserId(Long reviewedUserId);

    List<Review> findBySessionId(Long sessionId);
}
