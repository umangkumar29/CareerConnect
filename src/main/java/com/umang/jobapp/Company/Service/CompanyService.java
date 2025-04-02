package com.umang.jobapp.Company.Service;

import java.util.List;

import com.umang.jobapp.Company.Entity.Company;

public interface CompanyService {
    List<Company> getAllCompanies();
    Company getCompanyById(Long compId);
    void addCompany(Company company);
    boolean deleteCompany(Long compId);
    boolean updateCompany(Long compId, Company company);
}
