package com.github.vaatech.migrator.moneywise.migrations.accounts;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "_ID")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "ingoing_balance")
  private Boolean ingoingBalance;

  @Column(name = "ingoing_balance_date")
  private LocalDateTime ingoingBalanceDate;

  @Column(name = "balance")
  private BigDecimal balance;

  @Column(name = "comment")
  private String comment;

  @Column(name = "balance_pending")
  private BigDecimal balancePending;

  @Column(name = "default_cleared")
  private Boolean defaultCleared;

  @Column(name = "include_in_total")
  private Boolean includeInTotal;
}
