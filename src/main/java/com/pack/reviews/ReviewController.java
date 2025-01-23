package com.pack.reviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private ReviewService reviewService;
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review) {
        boolean added = reviewService.addReview(companyId, review);
        if (added) {
            return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("review not saved", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewID}")
    public ResponseEntity<Review> findReviewById(@PathVariable Long companyId, @PathVariable Long reviewID){
        Review review = reviewService.getReviewById(companyId, reviewID);
        if(review != null){
            return new ResponseEntity<>(review, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/reviews/{reviewID}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewID, @RequestBody Review UpdatedReview){
        boolean updated = reviewService.updateReview(companyId, reviewID, UpdatedReview);
        if(updated){
            return new ResponseEntity<>("review updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("not updated", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        boolean deleted = reviewService.deleteReview(companyId, reviewId);
        if (deleted){
            return  new ResponseEntity<>("deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("not deleted", HttpStatus.NOT_FOUND);
    }
}
