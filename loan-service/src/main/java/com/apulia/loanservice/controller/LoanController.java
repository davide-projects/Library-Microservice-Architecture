package com.apulia.loanservice.controller;

import com.apulia.loanservice.dto.LoanDetailsDTO;
import com.apulia.loanservice.dto.LoanRequestDTO;
import com.apulia.loanservice.model.Loan;
import com.apulia.loanservice.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Integer id) {
        return ResponseEntity.ok(loanService.getLoanById(id));
    }

    @GetMapping("/details")
    public ResponseEntity<List<LoanDetailsDTO>> getLoanDetails() {
        return ResponseEntity.ok(loanService.getLoanDetails());
    }

    @PostMapping
    public ResponseEntity<List<Loan>> createLoans(@Valid @RequestBody LoanRequestDTO request) {
        List<Loan> created = loanService.createLoans(request);
        return ResponseEntity.created(URI.create("/loans")).body(created);
    }

    @PatchMapping("/{id}/return")
    public ResponseEntity<Loan> returnBook(@PathVariable Integer id) {
        return ResponseEntity.ok(loanService.returnBook(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Integer id) {
        loanService.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }
}
