package com.company.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.example.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
