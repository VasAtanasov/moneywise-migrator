package com.github.vaatech.moneywise.migrator.migrations.category;

import com.github.vaatech.moneywise.migrator.migrations.subcategory.SubCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "_ID")
  private Integer id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "category")
  private List<SubCategory> subCategories;
}
