package com.pack.job;

import com.pack.company.Company;
import jakarta.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String maxSalary;
    private String minSalary;
    private String location;

    @ManyToOne
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Job(Long id, String description, String maxSalary, String minSalary, String location, String title) {
        this.id = id;
        this.description = description;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.location = location;
        this.title = title;
    }

    public Job() {
    }

    public String getDescription() {
        return description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public String getLocation() {
        return location;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
