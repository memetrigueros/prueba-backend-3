package com.company.example.service;

import java.util.List;
import java.util.Optional;

import com.company.example.model.Company;

public interface ICompanyService {
    public List<Company> getAllCompanies();
    public Optional<Company> getCompanyById(Long id);
    public Company createCompany(Company company);
    public Company updateCompany(Long id, Company company);
    public void deleteCompany(Long id);
}
