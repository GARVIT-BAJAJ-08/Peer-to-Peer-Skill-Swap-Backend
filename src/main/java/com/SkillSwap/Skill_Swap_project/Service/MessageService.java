package com.SkillSwap.Skill_Swap_project.Service;

import com.SkillSwap.Skill_Swap_project.Entity.Message;
import com.SkillSwap.Skill_Swap_project.Repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private  final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Optional<Message> getMessageById(Long id) {
        return messageRepository.findById(id);
    }
    public Message addMessage(Message message) {
        message.setSentAt(LocalDateTime.now());
        return messageRepository.save(message);
    }

    public Message updateMessage(Long id, Message message) {
        Message existingMessage = messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message not found with id: " + id));

        existingMessage.setSender(message.getSender());
        existingMessage.setReceiver(message.getReceiver());
        existingMessage.setContent(message.getContent());

        return messageRepository.save(existingMessage);
    }
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }

    public List<Message> getBySender(Long senderId) {
        return messageRepository.findBySenderId(senderId);
    }

    public List<Message> getByReceiver(Long receiverId) {
        return messageRepository.findByReceiverId(receiverId);
    }

    public List<Message> getConversation(Long senderId, Long receiverId) {
        return messageRepository.findConversation(senderId, receiverId);
    }
}
