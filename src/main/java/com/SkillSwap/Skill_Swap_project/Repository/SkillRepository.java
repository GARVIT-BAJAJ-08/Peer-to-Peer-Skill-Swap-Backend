package com.SkillSwap.Skill_Swap_project.Repository;

import com.SkillSwap.Skill_Swap_project.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository  extends JpaRepository<Skill,Long> {
    List<Skill> findByCategory(String category);
    List<Skill>findByUserId(Long id);
}
