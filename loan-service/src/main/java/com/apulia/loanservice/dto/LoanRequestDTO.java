package com.apulia.loanservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class LoanRequestDTO {

    @NotEmpty(message = "Field 'bookIds' cannot be empty")
    @JsonProperty("bookIds")
    private final List<Integer> bookIds;

    @NotNull(message = "Field 'memberId' is required")
    @JsonProperty("memberId")
    private final Integer memberId;

    public LoanRequestDTO(
            @JsonProperty("bookIds") List<Integer> bookIds,
            @JsonProperty("memberId") Integer memberId
    ) {
        this.bookIds = bookIds;
        this.memberId = memberId;
    }

    public List<Integer> getBookIds() {
        return bookIds;
    }

    public Integer getMemberId() {
        return memberId;
    }
}
