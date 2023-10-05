package com.github.vaatech.migrator.moneywise.migrations.currency;

import com.github.vaatech.migrator.util.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MWCurrencyRepository extends BaseRepository<MWCurrency, Integer> {}
