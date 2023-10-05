package com.github.vaatech.migrator.moneymanager.currency;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "CURRENCY")
@Getter
@Setter
public class MMCurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "uid")
    private String uid;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ISO")
    private String iso;

    @Column(name = "MAIN_ISO")
    private String mainIso;

    @Column(name = "IS_DEL")
    private Boolean isDeleted;

    @Column(name = "ORDER_SEQ")
    private Integer orderSequence;

    @Column(name = "RATE")
    private BigDecimal rate;

    @Column(name = "SYMBOL")
    private String symbol;

    @Column(name = "INSERT_TYPE")
    private String insertType;

    @Column(name = "SYMBOL_POSITION")
    private String symbolPosition;

    @Column(name = "IS_MAIN_CURRENCY")
    private Boolean isMainCurrency;

    @Column(name = "IS_SHOW")
    private Boolean isShow;

    @Column(name = "MODIFY_DATE")
    private LocalDateTime modifiedOn;

    @Column(name = "DECIMAL_POINT")
    private Integer decimalPoint;
}
