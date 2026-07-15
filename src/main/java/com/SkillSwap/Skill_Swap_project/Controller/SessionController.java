package com.SkillSwap.Skill_Swap_project.Controller;

import com.SkillSwap.Skill_Swap_project.Entity.Session;
import com.SkillSwap.Skill_Swap_project.Service.SessionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sessions")
@CrossOrigin
public class SessionController {

     private final SessionService sessionService;
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public List<Session> getAllSessions() {
        return sessionService.getAllSessions();
    }
    @GetMapping("/{id}")
    public Optional<Session> getSessionById(@PathVariable Long id) {
        return sessionService.getSessionById(id);
    }

    @PostMapping
    public Session addSession(@RequestBody Session session) {
        return sessionService.addSession(session);
    }

    @PutMapping("/{id}")
    public Session updateSession(@PathVariable Long id, @RequestBody Session session) {
        return sessionService.updateSession(id, session);
    }
    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable Long id) {
        sessionService.deleteSession(id);
    }

    @GetMapping("/teacher/{teacherId}")
    public List<Session> getByTeacher(@PathVariable Long teacherId) {
        return sessionService.getByTeacher(teacherId);
    }

    @GetMapping("/learner/{learnerId}")
    public List<Session> getByLearner(@PathVariable Long learnerId) {
        return sessionService.getByLearner(learnerId);
    }
    @GetMapping("/status/{status}")
    public List<Session> getByStatus(@PathVariable String status) {
        return sessionService.getByStatus(status);
    }


}
