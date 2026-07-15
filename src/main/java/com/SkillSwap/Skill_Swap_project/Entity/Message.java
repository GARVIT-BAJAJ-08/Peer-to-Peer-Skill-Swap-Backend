package com.SkillSwap.Skill_Swap_project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Message {
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

    private String content;
    private LocalDateTime sentAt;
}


