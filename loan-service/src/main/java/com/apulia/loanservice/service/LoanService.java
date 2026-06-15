package com.apulia.loanservice.service;

import com.apulia.loanservice.client.BookClient;
import com.apulia.loanservice.client.MemberClient;
import com.apulia.loanservice.dto.LoanDetailsDTO;
import com.apulia.loanservice.dto.LoanRequestDTO;
import com.apulia.loanservice.exception.LoanNotFoundException;
import com.apulia.loanservice.exception.ValidationException;
import com.apulia.loanservice.model.Loan;
import com.apulia.loanservice.repository.LoanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookClient bookClient;
    private final MemberClient memberClient;

    public LoanService(LoanRepository loanRepository,
                       BookClient bookClient,
                       MemberClient memberClient) {
        this.loanRepository = loanRepository;
        this.bookClient = bookClient;
        this.memberClient = memberClient;
    }

    // GET ALL
    @Transactional(readOnly = true)
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    // GET BY ID
    @Transactional(readOnly = true)
    public Loan getLoanById(Integer id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new LoanNotFoundException("Loan with ID " + id + " not found"));
    }

    // CREATE MULTIPLE LOANS
    @Transactional
    public List<Loan> createLoans(LoanRequestDTO request) {

        validateRequest(request);
        validateMember(request.getMemberId());
        return request.getBookIds().stream()
                .map(bookId -> createSingleLoan(bookId, request.getMemberId()))
                .toList();
    }

    private Loan createSingleLoan(Integer bookId, Integer memberId) {
        validateBook(bookId);
        if (isBookAlreadyLoaned(bookId)) {
            throw new ValidationException("Book with ID " + bookId + " is already loaned");
        }

        Loan loan = new Loan(bookId, memberId, LocalDate.now());
        return loanRepository.save(loan);
    }

    // RETURN BOOK
    @Transactional
    public Loan returnBook(Integer id) {
        Loan loan = getLoanById(id);

        if (loan.getReturnDate() != null) {
            throw new ValidationException("Loan with ID " + id + " is already returned");
        }

        loan.setReturnDate(LocalDate.now());
        return loanRepository.save(loan);
    }

    // DELETE
    @Transactional
    public void deleteLoan(Integer id) {
        Loan loan = getLoanById(id);
        loanRepository.delete(loan);
    }

    // CHECK IF BOOK IS ALREADY LOANED
    public boolean isBookAlreadyLoaned(Integer bookId) {
        return loanRepository.findByBookIdAndReturnDateIsNull(bookId).isPresent();
    }


    // VALIDATION HELPERS
    private void validateRequest(LoanRequestDTO request) {
        if (request.getBookIds() == null || request.getBookIds().isEmpty()) {
            throw new ValidationException("Book list cannot be empty");
        }
    }

    private void validateBook(Integer bookId) {
        bookClient.getBookById(bookId);
    }

    private void validateMember(Integer memberId) {
        memberClient.getMemberById(memberId);
    }

    public List<LoanDetailsDTO> getLoanDetails() {
        List<Loan> loans = loanRepository.findAll();

        return loans.stream()
                .map(loan -> {
                    var book = bookClient.getBookById(loan.getBookId());
                    var member = memberClient.getMemberById(loan.getMemberId());

                    return new LoanDetailsDTO(
                            loan,
                            book,
                            member,
                            loan.getLoanDate(),
                            loan.getReturnDate()
                    );
                })
                .toList();
    }

}
