package com.SkillSwap.Skill_Swap_project.Service;

import com.SkillSwap.Skill_Swap_project.Entity.Skill;
import com.SkillSwap.Skill_Swap_project.Repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

   private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> getAllSkills(){
        return skillRepository.findAll();
    }
    public Optional<Skill> getSkillById(long id){
        return  skillRepository.findById(id);
    }

    public Skill addSkill(Skill skill){
       return skillRepository.save(skill);
    }

    public void deleteSkill(Long id){
       skillRepository.deleteById(id);
    }

    public List<Skill> getSkillByCategory(String category){
        return skillRepository.findByCategory(category);
    }

    public Skill updateSkill(Long id,Skill skill){
        Skill existingSkill = skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found with id: " + id));

        existingSkill.setTitle(skill.getTitle());
        existingSkill.setDescription(skill.getDescription());
        existingSkill.setCategory(skill.getCategory());
        existingSkill.setLevel(skill.getLevel());

        return skillRepository.save(existingSkill);
    }
    public List<Skill> geSkillsByUserId(Long id){
        return skillRepository.findByUserId(id);
    }


}
