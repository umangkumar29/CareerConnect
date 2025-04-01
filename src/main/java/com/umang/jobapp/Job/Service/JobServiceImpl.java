package com.umang.jobapp.Job.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.umang.jobapp.Job.Entity.Job;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<>();
    private Long nextJobid = 1L;

    @Override
    public List<Job> getAllJobs() {
        return jobs;
    }

    @Override
    public Job getJobById(Long id) {
        for(Job job: jobs){
            if(job.getId() == id){
                return job;
            }
        }
        return null;
    }

    @Override
    public void addJob(Job job) {
        job.setId(nextJobid++);
        jobs.add(job);
    }

    @Override
    public boolean deleteJob(Long id) {
        for(Job job: jobs){
            if(job.getId() == id){
                jobs.remove(job);
                return true;
            }
        }
        return false;
        // jobs.removeIf(job -> job.getId() == id);
    }

}
