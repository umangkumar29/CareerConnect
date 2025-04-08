package com.umang.jobapp.Review.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umang.jobapp.Review.Entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByCompany_CompId(Long companyId);

}
