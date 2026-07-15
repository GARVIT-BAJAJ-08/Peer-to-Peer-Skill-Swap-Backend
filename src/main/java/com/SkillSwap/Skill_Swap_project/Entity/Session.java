package com.SkillSwap.Skill_Swap_project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonIgnoreProperties({"skills", "password"})
    private User teacher;

    @ManyToOne
    @JoinColumn(name = "learner_id")
    @JsonIgnoreProperties({"skills", "password"})
    private User learner;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    @JsonIgnoreProperties("user")
    private Skill skill;

    private LocalDate sessionDate;
    private LocalTime sessionTime;
    private String status;
}
