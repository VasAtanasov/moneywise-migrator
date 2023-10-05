package com.github.vaatech.migrator.moneymanager.accounts;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ASSETS")
@Getter
@Setter
public class Asset {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;

  @Column(name = "CARD_DAY_FIN")
  private String cardDayFinish;

  @Column(name = "CARD_DAY_PAY")
  private String cardDayPay;

  @Column(name = "NIC_NAME")
  private String name;

  @Column(name = "ORDERSEQ")
  private Integer orderSequence;

  @Column(name = "ZDATA")
  private String isActive;

  @Column(name = "ZDATA1")
  private String description;

  @Column(name = "ZDATA2")
  private String zdata2;

  @Column(name = "IS_TRANS_EXPENSE")
  private Boolean isTransExpense;

  @Column(name = "IS_CARD_AUTO_PAY")
  private Boolean isCardAutoPay;

  @Column(name = "A_UTIME")
  private LocalDateTime createdOn;

  @Column(name = "uid")
  private String uid;

  @Column(name = "currencyUid")
  private String currencyUid;

  @Column(name = "cardAssetUid")
  private String cardAssetUid;

  @Column(name = "groupUid")
  private String groupUid;
}
