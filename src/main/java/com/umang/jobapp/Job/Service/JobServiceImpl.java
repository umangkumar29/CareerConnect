package com.umang.jobapp.Job.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.umang.jobapp.Job.Entity.Job;
import com.umang.jobapp.Job.Repository.JobRepository;

@Service
public class JobServiceImpl implements JobService {

    // private List<Job> jobs = new ArrayList<>();
    @Autowired
    private JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public void addJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public boolean deleteJob(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job job) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job j = jobOptional.get();
            j.setJobTitle(job.getJobTitle());
            j.setJobDescription(job.getJobDescription());
            j.setJobType(job.getJobType());
            j.setLocation(job.getLocation());
            j.setMinSalary(job.getMinSalary());
            j.setMaxSalary(job.getMaxSalary());
            try {
                jobRepository.save(j);
                return true;
            } catch (ObjectOptimisticLockingFailureException e) {
                return false;
            }
        }
        return false;
    }

}
