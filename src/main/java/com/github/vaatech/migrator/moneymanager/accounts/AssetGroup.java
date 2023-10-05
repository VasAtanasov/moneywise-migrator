package com.github.vaatech.migrator.moneymanager.accounts;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "ASSETGROUP")
@Getter
@Setter
public class AssetGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEVICE_ID")
    private Integer id;

    @Column(name = "uid")
    private String uid;

    @Column(name = "IS_DEL")
    private Boolean isDeleted;

    @Column(name = "USETIME")
    private LocalDateTime createdOn;

    @Column(name = "ACC_GROUP_NAME")
    private String name;

    @Column(name = "TYPE")
    private Integer type;

    @Column(name = "ORDERSEQ")
    private Integer orderSequence;
}
