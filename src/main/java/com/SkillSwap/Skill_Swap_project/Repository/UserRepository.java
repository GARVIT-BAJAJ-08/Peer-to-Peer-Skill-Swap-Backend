package com.SkillSwap.Skill_Swap_project.Repository;

import com.SkillSwap.Skill_Swap_project.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
