package com.github.vaatech.migrator.moneywise.migrations.transactions;

import com.github.vaatech.migrator.util.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MWTransactionRepository extends BaseRepository<MWTransaction, Integer> {}
