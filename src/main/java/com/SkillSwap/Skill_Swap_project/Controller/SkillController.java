package com.SkillSwap.Skill_Swap_project.Controller;

import com.SkillSwap.Skill_Swap_project.Entity.Skill;
import com.SkillSwap.Skill_Swap_project.Service.SkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin
public class SkillController {
    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }
    @GetMapping
    public List<Skill> getAllSkills(){
        return skillService.getAllSkills();
    }
    @PostMapping
    public  Skill addSkill(@RequestBody Skill skill){
       return skillService.addSkill(skill);
    }

    @GetMapping("/{id}")
    public Optional<Skill> getSkillById(@PathVariable Long id){
        return skillService.getSkillById(id);

    }
    @PutMapping("/{id}")
    public Skill updateSkill( @PathVariable Long id ,  @RequestBody Skill skill ){
        return skillService.updateSkill(id,skill);
    }
    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id){
        skillService.deleteSkill(id);
    }

    @GetMapping("/category/{category}")
    public List<Skill> getSkillsByCategory(@PathVariable String category) {
        return skillService.getSkillByCategory(category);
    }

    @GetMapping("/user/{userId}")
    public List<Skill> getSkillsByUserId(@PathVariable Long userId) {
        return skillService.geSkillsByUserId(userId);
    }



}
