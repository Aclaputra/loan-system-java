package com.enigmacamp.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Date;

@Data
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mst_customer")
@SQLDelete(sql = "UPDATE mst_customer SET status = true WHERE id = ?")
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
    @Column(columnDefinition = "boolean default false")
    private Boolean status;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Boolean getStatus() {
        return status;
    }

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
                }
                """,
                this.id,
                this.firstName,
                this.lastName,
                this.dateOfBirth,
                this.phone,
                this.status,
                this.user);
    }
}