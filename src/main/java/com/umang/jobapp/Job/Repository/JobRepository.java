package com.umang.jobapp.Job.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umang.jobapp.Job.Entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

}
