package com.pack.company;

import java.util.List;

public interface CompanyService {
    List<Company> getCompany();
    boolean updateCompany(Long id, Company Updatedcompany);
    void createCompany(Company company);
    Company getById(Long id);
    boolean deleteCompany(Long id);
}
