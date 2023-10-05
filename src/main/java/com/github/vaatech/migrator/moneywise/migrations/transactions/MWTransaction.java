package com.github.vaatech.migrator.moneywise.migrations.transactions;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class MWTransaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "_ID")
  private Integer id;

  @Column(name = "created")
  private LocalDateTime created;

  @Column(name = "year")
  private Integer year;

  @Column(name = "month")
  private Integer month;

  @Column(name = "day")
  private Integer day;

  @Column(name = "week")
  private Integer week;

  @Column(name = "category")
  private Integer category;

  @Column(name = "expense")
  private String expense;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "currency")
  private String currency;

  @Column(name = "amount_default_currency")
  private BigDecimal amountDefaultCurrency;

  @Column(name = "is_expense")
  private Boolean isExpense;

  @Column(name = "account_id")
  private Integer accountId;

  @Column(name = "transfer_id")
  private Integer transferId;

  @Column(name = "recurring_id")
  private Integer recurringId;

  @Column(name = "cleared")
  private Boolean isCleared;

  @Column(name = "entry_type")
  private Integer entryType;

  @Column(name = "parent_id")
  private Integer parentId;

  @Column(name = "note")
  private String note;

  @Column(name = "date")
  private LocalDateTime date;

  @Column(name = "account_balance")
  private BigDecimal accountBalance;

  @Column(name = "pending_account_balance")
  private BigDecimal pendingAccountBalance;

  @Column(name = "modified_date")
  private LocalDateTime updated;

  @Column(name = "sub_category")
  private Integer subCategory;
}
