package com.pack.reviews;

import java.util.List;

public interface ReviewService {
    boolean addReview(Long companyID, Review review);
    Review getReviewById(Long CompanyID,Long id);
    boolean updateReview(Long CompanyID,Long id, Review UpdatedReview);
    boolean deleteReview(Long CompanyID, Long id);
    List<Review> getAllReviews(Long companyID);
}
