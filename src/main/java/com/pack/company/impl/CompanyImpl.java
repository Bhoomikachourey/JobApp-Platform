package com.pack.company.impl;

import com.pack.company.Company;
import com.pack.company.CompanyRepository;
import com.pack.company.CompanyService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyImpl implements CompanyService {
    private CompanyRepository companyRepository;

    public CompanyImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getCompany() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Long id, Company updatedCompany) {
        Optional<Company> optional = companyRepository.findById(id);
        if (optional.isPresent()) {
            Company company = optional.get();
            company.setName(updatedCompany.getName());
            company.setDescription(updatedCompany.getDescription());
            company.setJob(updatedCompany.getJob());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(@RequestBody Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompany(Long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        }
     catch(Exception e)

    {
        return false;
    }


}
}
