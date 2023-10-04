package com.github.vaatech.migrator.moneywise.migrations.subcategory;

import com.github.vaatech.migrator.moneywise.migrations.category.MWCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sub_categories")
@Getter
@Setter
public class MWSubCategory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "_ID")
  private Integer id;

  @Column(name = "name")
  private String name;

  @ManyToOne
  @JoinColumn(name = "parent_category_id")
  private MWCategory category;
}
