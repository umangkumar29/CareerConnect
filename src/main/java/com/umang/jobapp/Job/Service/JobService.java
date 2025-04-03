package com.umang.jobapp.Job.Service;

import java.util.List;
import com.umang.jobapp.Job.Entity.Job;

public interface JobService {
    List<Job> getAllJobs();

    Job getJobById(Long id);

    void addJob(Job job);

    boolean deleteJob(Long id);

    boolean updateJob(Long id, Job job);

}
