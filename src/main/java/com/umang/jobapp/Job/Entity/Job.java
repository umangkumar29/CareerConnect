package com.umang.jobapp.Job.Entity;

public class Job {
    private Long Id;
    private String minSalary;
    private String maxSalary;
    private String location;
    private String jobType;
    private String jobTitle;
    private String jobDescription;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Job(Long id, String minSalary, String maxSalary, String location, String jobType, String jobTitle,
            String jobDescription) {
        Id = id;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
        this.jobType = jobType;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
    }
}
