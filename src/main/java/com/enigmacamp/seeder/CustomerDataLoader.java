package com.enigmacamp.seeder;

import com.enigmacamp.constant.ERole;
import com.enigmacamp.entity.Customer;
import com.enigmacamp.entity.Role;
import com.enigmacamp.entity.User;
import com.enigmacamp.repository.CustomerRepository;
import com.enigmacamp.repository.RoleRepository;
import com.enigmacamp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

@Component
public class CustomerDataLoader implements CommandLineRunner {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        loadCustomerData();
    }

    private void loadCustomerData() {
        if (customerRepository.count() == 0) {
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
                    .status("active")
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
