package com.SkillSwap.Skill_Swap_project.Repository;

import com.SkillSwap.Skill_Swap_project.Entity.SwapRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SwapRequestRepository extends JpaRepository<SwapRequest,Long> {
    List<SwapRequest> findBySenderId(Long senderId);
    List<SwapRequest>findByReceiverId(Long receiverId);
    List<SwapRequest> findByStatus(String status);
}

