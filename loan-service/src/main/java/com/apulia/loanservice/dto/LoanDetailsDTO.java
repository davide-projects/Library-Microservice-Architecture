package com.apulia.loanservice.dto;

import com.apulia.loanservice.model.Loan;
import java.time.LocalDate;

public record LoanDetailsDTO(
        Loan loan,
        BookDTO book,
        MemberDTO member,
        LocalDate loanDate,
        LocalDate returnDate
) {}
