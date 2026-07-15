package com.SkillSwap.Skill_Swap_project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reviewer_id")
    @JsonIgnoreProperties({"skills", "password"})
    private User reviewer;

    @ManyToOne
    @JoinColumn(name = "reviewed_user_id")
    @JsonIgnoreProperties({"skills", "password"})
    private User reviewedUser;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    private int rating;
    private String comment;
}
