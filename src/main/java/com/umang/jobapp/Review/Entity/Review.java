package com.umang.jobapp.Review.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.umang.jobapp.Company.Entity.Company;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reviewTitle;
    private String reviewDescription;
    private double Rating;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Review() {
    }

    public Review(Long id, String reviewTitle, String reviewDescription, double rating) {
        this.id = id;
        this.reviewTitle = reviewTitle;
        this.reviewDescription = reviewDescription;
        Rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }

}
