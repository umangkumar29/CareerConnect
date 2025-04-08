package com.umang.jobapp.Review.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.umang.jobapp.Review.Entity.Review;
import com.umang.jobapp.Review.Service.ReviewService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
// @RequestMapping("/compaines/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/companies/{companyId}/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/companies/{companyId}/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review) {
        boolean isreviewSaved = reviewService.addReview(companyId, review);
        if (isreviewSaved == false)
            return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/companies/{companyId}/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId,
            @PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getReview(companyId, reviewId), HttpStatus.OK);
    }

    @PutMapping("/companies/{companyId}/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId,
            @RequestBody Review review) {
        boolean isreviewUpdated = reviewService.updateReview(companyId, reviewId, review);
        if (isreviewUpdated == false)
            return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/companies/{companyId}/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        boolean isreviewDeleted = reviewService.deleteReview(companyId, reviewId);
        if (isreviewDeleted == false)
            return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
    }
}
