package com.github.vaatech.migrator.moneymanager.category;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ZCATEGORY")
@Getter
@Setter
public class MMCategory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;

  @Column(name = "C_IS_DEL")
  private Boolean isDeleted;

  @Column(name = "C_UTIME")
  private LocalDateTime createdOn;

  @Column(name = "uid", insertable = false, updatable = false)
  private String uid;

  @Column(name = "NAME")
  private String name;

  @Column(name = "ORDERSEQ")
  private Integer orderSequence;

  @Column(name = "TYPE")
  @Enumerated(EnumType.ORDINAL)
  private CategoryType type;

  // Status shows if the category is root(0) or is sub-category(2)
  @Column(name = "STATUS")
  private Integer status;

  @Column(name = "pUid")
  private String pUid;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumns({
    @JoinColumn(name = "pUid", insertable = false, updatable = false)
  })
  private MMCategory parent;

  @OneToMany(
      mappedBy = "parent",
      cascade = CascadeType.ALL,
      orphanRemoval = true,
      fetch = FetchType.LAZY)
  private Set<MMCategory> subCategories = new HashSet<>();
}
