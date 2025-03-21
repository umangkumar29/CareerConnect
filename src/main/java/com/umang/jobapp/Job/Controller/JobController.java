package com.umang.jobapp.Job.Controller;

import java.util.ArrayList;
import java.util.List;
import com.umang.jobapp.Job.Entity.Job;

public class JobController {

    private List<Job> jobs = new ArrayList<>();
    public List<Job> getAllJobs() {
        return jobs;
    }
}
