package com.umang.jobapp.Job.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.umang.jobapp.Job.Entity.Job;
import com.umang.jobapp.Job.Service.JobService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class JobController {

    
    private JobService jobService;

    //It is a constructor based dependency injection (SERVICE -> CONTROLLER)
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job != null){
            return new ResponseEntity<>(job, HttpStatus.OK);    
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    


    @PostMapping("/jobs")
    public String addJob(@RequestBody Job job){
        jobService.addJob(job);
        return "Job added successfully";
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted = jobService.deleteJob(id);
        if(deleted){
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
        }
    }


}
