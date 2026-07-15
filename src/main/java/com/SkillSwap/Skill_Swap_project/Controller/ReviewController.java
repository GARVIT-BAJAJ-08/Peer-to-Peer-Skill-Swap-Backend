package com.SkillSwap.Skill_Swap_project.Controller;

import com.SkillSwap.Skill_Swap_project.Entity.Review;
import com.SkillSwap.Skill_Swap_project.Service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public Optional<Review> getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review review) {
        return reviewService.updateReview(id, review);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }

    @GetMapping("/reviewer/{reviewerId}")
    public List<Review> getByReviewer(@PathVariable Long reviewerId) {
        return reviewService.getByReviewer(reviewerId);
    }

    @GetMapping("/reviewed-user/{reviewedUserId}")
    public List<Review> getByReviewedUser(@PathVariable Long reviewedUserId) {
        return reviewService.getByReviewedUser(reviewedUserId);
    }

    @GetMapping("/session/{sessionId}")
    public List<Review> getBySession(@PathVariable Long sessionId) {
        return reviewService.getBySession(sessionId);
    }
}
