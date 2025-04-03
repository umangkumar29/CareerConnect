package com.umang.jobapp.Company.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.umang.jobapp.Company.Entity.Company;
import com.umang.jobapp.Company.Repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long compId) {
        return companyRepository.findById(compId).orElse(null);
    }

    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompany(Long compId) {
        try {
            companyRepository.deleteById(compId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateCompany(Long compId, Company company) {
        Optional<Company> companyOptional = companyRepository.findById(compId);
        if (companyOptional.isPresent()) {
            Company c = companyOptional.get();
            c.setCompName(company.getCompName());
            c.setCompDescription(company.getCompDescription());
            c.setCompLocation(company.getCompLocation());
            try {
                companyRepository.save(c);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

}
