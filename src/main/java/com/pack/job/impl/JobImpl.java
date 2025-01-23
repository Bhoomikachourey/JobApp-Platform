package com.pack.job.impl;

import com.pack.job.Job;
import com.pack.job.JobRepository;
import com.pack.job.JobService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

@Service
public class JobImpl implements JobService {
    JobRepository jobRepository;

    public JobImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> getAll() {
        return jobRepository.findAll();
    }

    @Override
    public void addJob(@RequestBody Job job) {
       jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
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
    public boolean updateById(Long id, Job updatedJob) {
        Optional<Job> optional = jobRepository.findById(id);

            if(optional.isPresent()){
                Job job = optional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setLocation(updatedJob.getLocation());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());
                jobRepository.save(job);
                return true;
            }
            return false;
        }

    }



