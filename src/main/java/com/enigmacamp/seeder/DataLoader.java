package com.enigmacamp.seeder;

import com.enigmacamp.constant.ApprovalStatus;
import com.enigmacamp.constant.EInstalmentType;
import com.enigmacamp.constant.ERole;
import com.enigmacamp.constant.LoanStatus;
import com.enigmacamp.model.entity.*;
import com.enigmacamp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
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
    InstalmentTypeRepository installmentTypeRepository;
    @Autowired
    LoanTypeRepository loanTypeRepository;
    @Autowired
    LoanTransactionRepository loanTransactionRepository;
    @Autowired
    LoanTransactionDetailRepository loanTransactionDetailRepository;

    @Override
    public void run(String... args) throws Exception {
        runSeeder();
    }

    private void runSeeder() {
        List<InstalmentType> instalmentTypes = new ArrayList<>();
        List<LoanType> loanTypes = new ArrayList<>();
        Customer customer = null;

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

            customer = Customer.builder()
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

        if (installmentTypeRepository.count() == 0) {
            instalmentTypes = List.of(
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

        if (loanTypeRepository.count() == 0) {
            loanTypes = List.of(
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

        if (loanTransactionRepository.count() == 0) {
            LoanTransactionDetail loanTransactionDetail = LoanTransactionDetail.builder()
                    .transactionDate(Long.parseLong("1661091574279"))
                    .nominal(1.03E7)
                    .loanStatus(LoanStatus.PAID)
                    .createdAt(Long.parseLong("1661002579786"))
                    .updatedAt(Long.parseLong("1661091574307"))
                    .build();



            LoanTransaction loanTransaction = LoanTransaction.builder()
                    .instalmentType(instalmentTypes.get(0))
                    .loanType(loanTypes.get(0))
                    .customer(customer)
                    .nominal(10000000.0)
                    .approvedAt(Long.parseLong("1661091574279"))
                    .approvedBy("rifqyomp@gmail.com")
                    .approvalStatus(ApprovalStatus.APPROVED)
                    .loanTransactionDetails(List.of(loanTransactionDetail))
                    .createdAt(Long.parseLong("1661106557370"))
                    .updatedAt(null)
                    .build();

            LoanTransaction savedLoanTransaction = loanTransactionRepository.save(loanTransaction);
            loanTransactionDetail.setLoanTransaction(savedLoanTransaction);
            LoanTransactionDetail savedLoanTransactionDetail = loanTransactionDetailRepository.save(loanTransactionDetail);

            System.out.println("Saved Loan Transaction: " + savedLoanTransaction);
            System.out.println("Saved Loan Transaction Detail: " + savedLoanTransactionDetail);
        }
    }
}
