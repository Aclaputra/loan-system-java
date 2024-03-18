package com.enigmacamp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Date;
import java.time.LocalDate;

@Data
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mst_customer")
@SQLDelete(sql = "UPDATE mst_customer SET deleted_at = CURRENT_DATE WHERE customer_id = ?")
public class Customer {
    @Id
    @UuidGenerator
    private String id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+7")
    private Date dateOfBirth;
    private String phone;
    private String status;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+7")
    @Column(name = "deleted_at")
    private LocalDate deletedAt = null;

    @Override
    public String toString() {
        return String.format("""
                Customer {
                    id : %s,
                    firstName : %s,
                    lastName : %s,
                    dateOfBirth : %s,
                    phone: %s,
                    status: %s,
                    user: %s,
                    deletedAt: %s
                }
                """,
                this.id,
                this.firstName,
                this.lastName,
                this.dateOfBirth,
                this.phone,
                this.status,
                this.user,
                this.deletedAt);
    }
}