package com.github.vaatech.moneywise.migrator.migrations.subcategory;

import com.github.vaatech.moneywise.migrator.migrations.category.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sub_categories")
@Getter
@Setter
public class SubCategory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "_ID")
  private Integer id;

  @Column(name = "name")
  private String name;

  @ManyToOne
  @JoinColumn(name = "parent_category_id")
  private Category category;
}
