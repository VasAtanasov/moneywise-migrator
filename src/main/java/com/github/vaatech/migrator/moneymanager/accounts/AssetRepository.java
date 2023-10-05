package com.github.vaatech.migrator.moneymanager.accounts;

import com.github.vaatech.migrator.util.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends BaseRepository<Asset, Integer> {}
