package com.enigmacamp.entity;

import com.enigmacamp.constant.EInstalmentType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Data
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_installment_type")
public class InstalmentType {
    @Id
    @UuidGenerator
    private String id;
    @Enumerated(EnumType.STRING)
    private EInstalmentType instalmentType;
}

