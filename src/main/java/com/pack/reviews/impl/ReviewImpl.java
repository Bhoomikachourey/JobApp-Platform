package com.pack.reviews.impl;

import com.pack.company.Company;
import com.pack.company.CompanyRepository;
import com.pack.reviews.Review;
import com.pack.reviews.ReviewRepository;
import com.pack.reviews.ReviewService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewImpl implements ReviewService
{
    private final ReviewRepository reviewRepository;
    private final CompanyRepository companyRepository;

    public ReviewImpl(ReviewRepository reviewRepository, CompanyRepository companyRepository) {
        this.reviewRepository = reviewRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public boolean addReview(Long companyID, Review review) {
    Company company = companyRepository.getById(companyID);
    if(company != null){
        review.setCompany(company);
        reviewRepository.save(review);
        return true;
    }
    return false;
    }

    @Override
    public Review getReviewById(Long CompanyID, Long id) {
        List<Review> reviews = reviewRepository.findByCompanyId(CompanyID);
        return reviews.stream().filter(review -> review.getId().equals(id))
                .findFirst().
                orElse(null);
    }

    @Override
    public boolean updateReview(Long CompanyID, Long id, Review UpdatedReview) {
      Review review = getReviewById(CompanyID, id);
      if(review != null) {
          review.setTitle(UpdatedReview.getTitle());
          review.setDescription(UpdatedReview.getDescription());
          review.setRating(UpdatedReview.getRating());
          reviewRepository.save(review);
          return true;
      }else {
          return false;
      }
    }

    @Override
    public boolean deleteReview(Long CompanyID, Long id) {
        Review review = getReviewById(CompanyID, id);
        if(review != null){
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Review> getAllReviews(Long companyID) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyID);
        return reviews;
    }


}
