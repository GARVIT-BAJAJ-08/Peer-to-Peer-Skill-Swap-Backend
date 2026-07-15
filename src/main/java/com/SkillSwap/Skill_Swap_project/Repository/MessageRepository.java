package com.SkillSwap.Skill_Swap_project.Repository;

import com.SkillSwap.Skill_Swap_project.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findBySenderId(Long senderId);

    List<Message> findByReceiverId(Long receiverId);

    List<Message> findBySenderIdAndReceiverId(Long senderId, Long receiverId);

    @Query("SELECT m FROM Message m WHERE " +
            "(m.sender.id = :user1Id AND m.receiver.id = :user2Id) OR " +
            "(m.sender.id = :user2Id AND m.receiver.id = :user1Id) " +
            "ORDER BY m.sentAt ASC")
    List<Message> findConversation(@Param("user1Id") Long user1Id, @Param("user2Id") Long user2Id);
}
