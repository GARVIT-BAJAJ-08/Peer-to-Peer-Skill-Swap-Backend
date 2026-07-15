package com.SkillSwap.Skill_Swap_project.Controller;

import com.SkillSwap.Skill_Swap_project.Entity.SwapRequest;
import com.SkillSwap.Skill_Swap_project.Service.SwapRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/swap-requests")
@CrossOrigin
public class SwapRequestController {
    private final SwapRequestService swapRequestService;

    public SwapRequestController(SwapRequestService swapRequestService) {
        this.swapRequestService = swapRequestService;
    }

    @GetMapping
    public List<SwapRequest> getAllSwapRequests() {
        return swapRequestService.getAllSwapRequests();
    }
    @GetMapping("/{id}")
    public Optional<SwapRequest> getSwapRequestById(@PathVariable Long id) {
        return swapRequestService.getSwapRequestById(id);
    }
    @PostMapping
    public SwapRequest addSwapRequest(@RequestBody SwapRequest swapRequest) {
        return swapRequestService.addSwapRequest(swapRequest);
    }

    @PutMapping("/{id}")
    public SwapRequest updateSwapRequest(@PathVariable Long id, @RequestBody SwapRequest swapRequest) {
        return swapRequestService.updateSwapRequest(id, swapRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteSwapRequest(@PathVariable Long id) {
        swapRequestService.deleteSwapRequest(id);
    }
    @GetMapping("/sender/{senderId}")
    public List<SwapRequest> getBySender(@PathVariable Long senderId) {
        return swapRequestService.getBySender(senderId);
    }

    @GetMapping("/receiver/{receiverId}")
    public List<SwapRequest> getByReceiver(@PathVariable Long receiverId) {
        return swapRequestService.getByReceiver(receiverId);
    }
    @GetMapping("/status/{status}")
    public List<SwapRequest> getByStatus(@PathVariable String status) {
        return swapRequestService.getByStatus(status);
    }



}
