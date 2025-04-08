package com.umang.jobapp.Company.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.umang.jobapp.Job.Entity.Job;
import com.umang.jobapp.Review.Entity.Review;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long compId;
    private String compName;
    private String compLocation;
    private String compDescription;

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<Review> review;

    public Company(List<Review> review) {
        this.review = review;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    /* For JPA */
    public Company() {
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompLocation() {
        return compLocation;
    }

    public void setCompLocation(String compLocation) {
        this.compLocation = compLocation;
    }

    public String getCompDescription() {
        return compDescription;
    }

    public void setCompDescription(String compDescription) {
        this.compDescription = compDescription;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

}
