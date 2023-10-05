package com.github.vaatech.migrator.moneymanager.transactions;

import com.github.vaatech.migrator.util.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MMTransactionRepository extends BaseRepository<MMTransaction, Integer> {}
