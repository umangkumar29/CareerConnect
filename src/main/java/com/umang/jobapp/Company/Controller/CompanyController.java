package com.umang.jobapp.Company.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umang.jobapp.Company.Entity.Company;
import com.umang.jobapp.Company.Service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{compId}")
    public Company getCompanyById(@PathVariable Long compId) {
        return companyService.getCompanyById(compId);
    }

    @PostMapping
    public String addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
        return "Company added successfully";
    }

    @DeleteMapping("/{compId}")
    public String deleteCompany(@PathVariable Long compId) {
        companyService.deleteCompany(compId);
        return "Company deleted successfully";
    }

    @PutMapping("/{compId}")
    public boolean updateCompany(@PathVariable Long compId, @RequestBody Company company) {
        return companyService.updateCompany(compId, company);
    }

}
