package com.pack.job;

import java.util.List;

public interface JobService {
    List<Job> getAll();
    void addJob(Job job);
    Job getJobById(Long id);
    boolean deleteJob(Long id);
    boolean updateById(Long id, Job updatedJob);
}
