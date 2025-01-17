package com.company.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.company.example.model.Company;
import com.company.example.repository.CompanyRepository;
import com.company.example.service.ICompanyService;

@Service
public class CompanyService implements ICompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
    @Override
    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }
    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }
    @Override
    public Company updateCompany(Long id, Company company) {
        boolean exists = companyRepository.existsById(id);
        if (exists) {
            company.setId(id);
            return companyRepository.save(company);
        } else {
            throw new ResponseStatusException(
	              HttpStatus.NOT_FOUND, "Empresa no encontrada");
        }
    }
    @Override
    public void deleteCompany(Long id) {
        boolean exists = companyRepository.existsById(id);
        if (exists) {
            companyRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
	              HttpStatus.NOT_FOUND, "Empresa no encontrada");
        }
    }
}
