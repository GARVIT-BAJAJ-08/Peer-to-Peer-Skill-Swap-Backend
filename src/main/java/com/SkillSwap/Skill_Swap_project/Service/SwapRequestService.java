package com.SkillSwap.Skill_Swap_project.Service;

import com.SkillSwap.Skill_Swap_project.Entity.SwapRequest;
import com.SkillSwap.Skill_Swap_project.Repository.SwapRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SwapRequestService {
     private final SwapRequestRepository swapRequestRepository;

    public SwapRequestService(SwapRequestRepository swapRequestRepository) {
        this.swapRequestRepository = swapRequestRepository;
    }
    public List<SwapRequest> getAllSwapRequests() {
        return swapRequestRepository.findAll();
    }

    public Optional<SwapRequest> getSwapRequestById(Long id) {
        return swapRequestRepository.findById(id);
    }
    public SwapRequest addSwapRequest(SwapRequest swapRequest) {
        return swapRequestRepository.save(swapRequest);
    }
    public SwapRequest updateSwapRequest(Long id, SwapRequest swapRequest) {
        SwapRequest existingRequest = swapRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Swap request not found with id: " + id));

        existingRequest.setSender(swapRequest.getSender());
        existingRequest.setReceiver(swapRequest.getReceiver());
        existingRequest.setRequestedSkill(swapRequest.getRequestedSkill());
        existingRequest.setOfferedSkill(swapRequest.getOfferedSkill());
        existingRequest.setStatus(swapRequest.getStatus());

        return swapRequestRepository.save(existingRequest);}
    public void deleteSwapRequest(Long id) {
        swapRequestRepository.deleteById(id);
    }
    public List<SwapRequest> getBySender(Long senderId) {
        return swapRequestRepository.findBySenderId(senderId);
    }
    public List<SwapRequest> getByReceiver(Long receiverId) {
        return swapRequestRepository.findByReceiverId(receiverId);
    }
    public List<SwapRequest> getByStatus(String status) {
        return swapRequestRepository.findByStatus(status);
    }

}
