package com.SkillSwap.Skill_Swap_project.Controller;

import com.SkillSwap.Skill_Swap_project.Entity.Message;
import com.SkillSwap.Skill_Swap_project.Service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public Optional<Message> getMessageById(@PathVariable Long id) {
        return messageService.getMessageById(id);
    }

    @PostMapping
    public Message addMessage(@RequestBody Message message) {
        return messageService.addMessage(message);
    }

    @PutMapping("/{id}")
    public Message updateMessage(@PathVariable Long id, @RequestBody Message message) {
        return messageService.updateMessage(id, message);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
    }

    @GetMapping("/sender/{senderId}")
    public List<Message> getBySender(@PathVariable Long senderId) {
        return messageService.getBySender(senderId);
    }

    @GetMapping("/receiver/{receiverId}")
    public List<Message> getByReceiver(@PathVariable Long receiverId) {
        return messageService.getByReceiver(receiverId);
    }

    @GetMapping("/conversation")
    public List<Message> getConversation(
            @RequestParam Long senderId,
            @RequestParam Long receiverId
    ) {
        return messageService.getConversation(senderId, receiverId);
    }
}
