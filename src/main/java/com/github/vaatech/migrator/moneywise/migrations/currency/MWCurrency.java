package com.github.vaatech.migrator.moneywise.migrations.currency;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "exchange_rates")
@Getter
@Setter
public class MWCurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_ID")
    private Integer id;

    @Column(name = "from_currency")
    private String fromCurrency;

    @Column(name = "from_amount")
    private Integer fromAmount;

    @Column(name = "to_currency")
    private String toCurrency;

    @Column(name = "to_amount")
    private BigDecimal toAmount;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "active")
    private Boolean isActive;
}
