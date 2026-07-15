package com.SkillSwap.Skill_Swap_project.Repository;

import com.SkillSwap.Skill_Swap_project.Entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {

    List<Session> findByTeacherId(Long teacherId);

    List<Session> findByLearnerId(Long learnerId);

    List<Session> findByStatus(String status);

}
