package com.SkillSwap.Skill_Swap_project.Service;

import com.SkillSwap.Skill_Swap_project.Entity.Review;
import com.SkillSwap.Skill_Swap_project.Repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    public List<Review> getAllReviews(){
         return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }
    public Review updateReview(Long id, Review review) {
        Review existingReview = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));

        existingReview.setReviewer(review.getReviewer());
        existingReview.setReviewedUser(review.getReviewedUser());
        existingReview.setSession(review.getSession());
        existingReview.setRating(review.getRating());
        existingReview.setComment(review.getComment());

        return reviewRepository.save(existingReview);
    }
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public List<Review> getByReviewer(Long reviewerId) {
        return reviewRepository.findByReviewerId(reviewerId);
    }

    public List<Review> getByReviewedUser(Long reviewedUserId) {
        return reviewRepository.findByReviewedUserId(reviewedUserId);
    }

    public List<Review> getBySession(Long sessionId) {
        return reviewRepository.findBySessionId(sessionId);
    }


}
