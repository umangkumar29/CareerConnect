package com.umang.jobapp.Company.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.umang.jobapp.Company.Entity.Company;

public interface CompanyRepository extends JpaRepository<Company , Long> {
    

}
