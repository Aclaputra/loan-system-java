package com.enigmacamp.service.impl;

import com.enigmacamp.constant.EInstalmentType;
import com.enigmacamp.constant.MessageConstant;
import com.enigmacamp.model.dto.request.installment.InstallmentTypeRequest;
import com.enigmacamp.model.dto.request.installment.InstallmentTypeUpdateRequest;
import com.enigmacamp.model.dto.response.installment.InstallmentTypeResponse;
import com.enigmacamp.model.entity.InstalmentType;
import com.enigmacamp.repository.InstallmentTypeRepository;
import com.enigmacamp.service.InstalmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstalmentTypeServiceImpl implements InstalmentTypeService {
    @Autowired
    private InstallmentTypeRepository installmentTypeRepository;

    @Override
    public InstallmentTypeResponse create(InstallmentTypeRequest request) {
        InstalmentType instalmentType = InstalmentType.builder()
                .instalmentType(EInstalmentType.valueOf(request.getInstalmentType()))
                .build();

        InstalmentType savedInstalmentType = installmentTypeRepository.save(instalmentType);

        return InstallmentTypeResponse.builder()
                .id(savedInstalmentType.getId())
                .instalmentType(String.valueOf(savedInstalmentType.getInstalmentType()))
                .build();
    }

    @Override
    public InstallmentTypeResponse getById(String id) {
        InstalmentType instalmentType = installmentTypeRepository.findById(id).get();

        return InstallmentTypeResponse.builder()
                .id(instalmentType.getId())
                .instalmentType(String.valueOf(instalmentType.getInstalmentType()))
                .build();
    }

    @Override
    public List<InstallmentTypeResponse> getAll() {
        List<InstalmentType> instalmentTypes = installmentTypeRepository.findAll();
        List<InstallmentTypeResponse> installmentTypeResponses = new ArrayList<>();

        instalmentTypes.forEach(instalmentType -> {
            InstallmentTypeResponse response = InstallmentTypeResponse.builder()
                    .id(instalmentType.getId())
                    .instalmentType(String.valueOf(instalmentType.getInstalmentType()))
                    .build();
            installmentTypeResponses.add(response);
        });

        return installmentTypeResponses;
    }

    @Override
    public InstallmentTypeResponse update(InstallmentTypeUpdateRequest request) {
        if (installmentTypeRepository.findById(request.getId()).isPresent()) {
            InstalmentType instalmentType = InstalmentType.builder()
                    .instalmentType(EInstalmentType.valueOf(request.getInstalmentType()))
                    .build();
            InstalmentType savedInsalmentType = installmentTypeRepository.save(instalmentType);

            return InstallmentTypeResponse.builder()
                    .id(savedInsalmentType.getId())
                    .instalmentType(String.valueOf(savedInsalmentType.getInstalmentType()))
                    .build();
        } else {
            throw new RuntimeException("Installment Type with id " + request.getId() + " not found");
        }
    }

    @Override
    public String deleteById(String id) {
        try {
            installmentTypeRepository.deleteById(id);
            return String.format(MessageConstant.DELETE_SUCCESS, id);
        } catch (Exception e) {
            throw new RuntimeException(
                    String.format(MessageConstant.DELETE_FAIL, id) +
                            " | with error: " + e.getMessage());
        }
    }
}
