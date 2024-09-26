package me.dio.web.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    private String number;

    @NotBlank
    @Column(length = 50, nullable = false)
    private String agency;

    @Column(precision = 13, scale = 2)
    private BigDecimal balance;

    @PrePersist
    public void prePersist() {
        if (balance == null) {
            balance = BigDecimal.valueOf(0);
        }
    }

    @Column(name = "additional_limit", precision = 13, scale = 2)
    private BigDecimal limit;
}
