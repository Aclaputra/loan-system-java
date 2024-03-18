package com.enigmacamp.service.impl;

import com.enigmacamp.constant.MessageConstant;
import com.enigmacamp.model.dto.request.loan.LoanTypeRequest;
import com.enigmacamp.model.dto.request.loan.LoanTypeUpdateRequest;
import com.enigmacamp.model.dto.response.loan.LoanTypeResponse;
import com.enigmacamp.model.entity.LoanType;
import com.enigmacamp.repository.LoanTypeRepository;
import com.enigmacamp.service.LoanTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanTypeServiceImpl implements LoanTypeService {

    @Autowired
    private LoanTypeRepository loanTypeRepository;

    @Override
    public LoanTypeResponse create(LoanTypeRequest request) {
        LoanType loanType = LoanType.builder()
                .type(request.getType())
                .maxLoan(request.getMaxLoan())
                .build();

        LoanType savedLoanType = loanTypeRepository.save(loanType);

        return LoanTypeResponse.builder()
                .type(savedLoanType.getType())
                .maxLoan(savedLoanType.getMaxLoan())
                .build();
    }

    @Override
    public LoanTypeResponse getById(String id) {
        LoanType loanType = loanTypeRepository.findById(id).get();

        return LoanTypeResponse.builder()
                .type(loanType.getType())
                .maxLoan(loanType.getMaxLoan())
                .build();
    }

    @Override
    public List<LoanTypeResponse> getAll() {
        List<LoanType> loanTypes = loanTypeRepository.findAll();
        List<LoanTypeResponse> loanTypeResponses = new ArrayList<>();

        loanTypes.forEach(loanType -> {
            LoanTypeResponse response = LoanTypeResponse.builder()
                    .type(loanType.getType())
                    .maxLoan(loanType.getMaxLoan())
                    .build();

            loanTypeResponses.add(response);
        });

        return loanTypeResponses;
    }

    @Override
    public LoanTypeResponse update(LoanTypeUpdateRequest request) {
        if (loanTypeRepository.findById(request.getId()).isPresent()) {
            LoanType loanType = LoanType.builder()
                    .id(request.getId())
                    .type(request.getType())
                    .maxLoan(request.getMaxLoan())
                    .build();

            LoanType savedLoanType = loanTypeRepository.save(loanType);
            return LoanTypeResponse.builder()
                    .id(savedLoanType.getId())
                    .type(savedLoanType.getType())
                    .maxLoan(savedLoanType.getMaxLoan())
                    .build();
        } else {
            throw new RuntimeException("Loan Type with id " + request.getId() + " not found");
        }
    }

    @Override
    public String deleteById(String id) {
        try {
            loanTypeRepository.deleteById(id);
            return String.format(MessageConstant.DELETE_SUCCESS, id);
        } catch (Exception e) {
            throw new RuntimeException(
                    String.format(MessageConstant.DELETE_FAIL, id) +
                            " | with error: " + e.getMessage());
        }
    }
}
