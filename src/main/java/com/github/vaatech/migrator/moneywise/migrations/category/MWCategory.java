package com.github.vaatech.migrator.moneywise.migrations.category;

import com.github.vaatech.migrator.moneywise.migrations.subcategory.MWSubCategory;
import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class MWCategory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "_ID")
  private Integer id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "category")
  private List<MWSubCategory> subCategories;

  public MWCategory addSubCategory(MWSubCategory subCategory) {
    subCategories.add(subCategory);
    subCategory.setCategory(this);
    return this;
  }

  public MWCategory removeSubCategory(MWSubCategory subCategory) {
    subCategories.remove(subCategory);
    subCategory.setCategory(null);
    return this;
  }
}
