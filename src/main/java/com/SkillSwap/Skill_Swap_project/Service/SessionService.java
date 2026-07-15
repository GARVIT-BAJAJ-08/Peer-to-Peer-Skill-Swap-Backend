package com.SkillSwap.Skill_Swap_project.Service;

import com.SkillSwap.Skill_Swap_project.Entity.Session;
import com.SkillSwap.Skill_Swap_project.Repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

   private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }
    public List<Session>getAllSessions(){
       return  sessionRepository.findAll();
    }
    public Optional<Session> getSessionById(Long id) {
        return sessionRepository.findById(id);
    }

    public Session addSession(Session session) {
        return sessionRepository.save(session);
    }
    public Session updateSession(Long id, Session session) {
        Session existingSession = sessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Session not found with id: " + id));

        existingSession.setTeacher(session.getTeacher());
        existingSession.setLearner(session.getLearner());
        existingSession.setSkill(session.getSkill());
        existingSession.setSessionDate(session.getSessionDate());
        existingSession.setSessionTime(session.getSessionTime());
        existingSession.setStatus(session.getStatus());

        return sessionRepository.save(existingSession);
    }
    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);
    }

    public List<Session> getByTeacher(Long teacherId) {
        return sessionRepository.findByTeacherId(teacherId);
    }

    public List<Session> getByLearner(Long learnerId) {
        return sessionRepository.findByLearnerId(learnerId);
    }

    public List<Session> getByStatus(String status) {
        return sessionRepository.findByStatus(status);
    }

}
