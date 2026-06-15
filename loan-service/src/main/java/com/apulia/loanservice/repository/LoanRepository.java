package com.apulia.loanservice.repository;

import com.apulia.loanservice.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

    Optional<Loan> findByBookIdAndReturnDateIsNull(Integer bookId);
}
