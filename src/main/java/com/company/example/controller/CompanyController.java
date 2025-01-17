package com.company.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.company.example.model.Company;
import com.company.example.service.ICompanyService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Api(tags = "Company")
@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    
    @Autowired
    private ICompanyService companyService;

    @ApiOperation(value = "Get all Companies")
    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @ApiOperation(value = "Get Company by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Optional<Company> company = companyService.getCompanyById(id);
        return company.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Create a new Company")
    @PostMapping
    public Company createCompany(@Valid @RequestBody Company company) {
        return companyService.createCompany(company);
    }

    @ApiOperation(value = "Update an existing Company")
    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @Valid @RequestBody Company company) {
        Optional<Company> existingCompany = companyService.getCompanyById(id);
        if (existingCompany.isPresent()) {
            return ResponseEntity.ok(companyService.updateCompany(id, company));
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Delete a Company")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }

}
