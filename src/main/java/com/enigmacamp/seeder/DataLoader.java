package com.enigmacamp.seeder;

import com.enigmacamp.constant.EInstalmentType;
import com.enigmacamp.constant.ERole;
import com.enigmacamp.model.entity.*;
import com.enigmacamp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    InstallmentTypeRepository installmentTypeRepository;
    @Autowired
    LoanTypeRepository loanTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        loadInstallmentType();
        loadLoanType();
        loadCustomerData();
    }

    private void loadLoanType() {
        if (loanTypeRepository.count() == 0) {
            List<LoanType> loanTypes = List.of(
                    LoanType.builder()
                            .type("Pinjaman Kredit Elektronik")
                            .maxLoan(10000000.0)
                            .build(),
                    LoanType.builder()
                            .type("Pinjaman Kredit Kendaraan")
                            .maxLoan(100000000.0)
                            .build()
            );

            List<LoanType> savedLoanTypes = loanTypeRepository.saveAll(loanTypes);

            System.out.println("Saved Loan Types: " + savedLoanTypes);
        }
    }

    private void loadInstallmentType() {
        if (installmentTypeRepository.count() == 0) {
            List<InstalmentType> instalmentTypes = List.of(
                    InstalmentType.builder()
                            .instalmentType(EInstalmentType.ONE_MONTH)
                            .build(),
                    InstalmentType.builder()
                            .instalmentType(EInstalmentType.THREE_MONTHS)
                            .build(),
                    InstalmentType.builder()
                            .instalmentType(EInstalmentType.NINE_MONTHS)
                            .build(),
                    InstalmentType.builder()
                            .instalmentType(EInstalmentType.SIXTH_MONTHS)
                            .build(),
                    InstalmentType.builder()
                            .instalmentType(EInstalmentType.TWELVE_MONTHS)
                            .build()
            );

            List<InstalmentType> savedInstallments = installmentTypeRepository.saveAll(instalmentTypes);

            System.out.println("Saved Installment Types" + savedInstallments);
        }
    }

    private void loadCustomerData() {
        if (
                customerRepository.count() == 0
                && roleRepository.count() == 0
                && userRepository.count() == 0
        ) {
            Optional<Role> roles = Optional.of(Role.builder()
                            .name(ERole.ROLE_CUSTOMER)
                            .build());

            User user = User.builder()
                    .email("user@gmail.com")
                    .password("password")
                    .roles(roles.stream().toList())
                    .build();

            Customer customer = Customer.builder()
                    .firstName("Muhammad")
                    .lastName("Acla")
                    .dateOfBirth(new Date(1))
                    .status(true)
                    .phone("8124779249")
                    .user(user)
                    .build();

            roleRepository.save(roles.orElse(null));
            userRepository.save(user);
            Customer savedCustomer = customerRepository.save(customer);

            StringBuilder builder = new StringBuilder();
            builder.append("successfully seed database\n");
            builder.append(savedCustomer);

            System.out.println(builder.toString());
        }
    }
}
