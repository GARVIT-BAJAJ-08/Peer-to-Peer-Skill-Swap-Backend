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
public class SwapRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    @JsonIgnoreProperties({"skills", "password"})
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    @JsonIgnoreProperties({"skills", "password"})
    private User receiver;

    @ManyToOne
    @JoinColumn(name = "requested_skill_id")
    @JsonIgnoreProperties("user")
    private Skill requestedSkill;

    private String offeredSkill;
    private String status;

}
