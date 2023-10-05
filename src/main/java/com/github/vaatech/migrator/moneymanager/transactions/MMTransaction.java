package com.github.vaatech.migrator.moneymanager.transactions;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "INOUTCOME")
@Getter
@Setter
public class MMTransaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "AID")
  private Integer id;

  @Column(name = "uid")
  private String uid;

  @Column(name = "assetUid")
  private String assetUid;

  @Column(name = "CARDDIVIDMONTH")
  private String cardDivIdMonth;

  @Column(name = "ctgUid")
  private String ctgUid;

  @Column(name = "toAssetUid")
  private String toAssetUid;

  @Column(name = "ZCONTENT")
  private String description;

  //  @Column(name = "ZDATE")
  //  private Instant dateTime;

  //  @Column(name = "WDATE")
  //  private LocalDate date;

  @Column(name = "wtime")
  private String wTime;

  @Column(name = "paid")
  private String paid;

  @Column(name = "DO_TYPE")
  private String doType;

  @Column(name = "ZMONEY")
  private String money;

  @Column(name = "txUidTrans")
  private String txUidTrans;

  @Column(name = "ZDATA")
  private String zData;

  @Column(name = "IN_ZMONEY")
  private String inMoney;

  @Column(name = "ASSET_NIC")
  private String assetNic;

  @Column(name = "CATEGORY_NAME")
  private String categoryName;

  @Column(name = "cardDivideUid")
  private String cardDivideUid;

  @Column(name = "CARD_DIVIDE_MONTH_STR")
  private String cardDivideMonth;

  @Column(name = "MARK")
  private Integer mark;

  @Column(name = "txUidFee")
  private String txUidFee;

  @Column(name = "IS_DEL")
  private Boolean isDeleted;

  @Column(name = "UTIME")
  private LocalDateTime modifiedOn;

  @Column(name = "currencyUid")
  private String currencyUid;

  @Column(name = "AMOUNT_ACCOUNT")
  private BigDecimal amountAccount;
}
