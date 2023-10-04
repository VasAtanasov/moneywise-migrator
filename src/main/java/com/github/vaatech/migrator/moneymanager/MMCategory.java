package com.github.vaatech.migrator.moneymanager;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ZCATEGORY")
@Getter
@Setter
public class MMCategory
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;

  @Column(name = "C_IS_DEL")
  private Boolean isDeleted;
}
