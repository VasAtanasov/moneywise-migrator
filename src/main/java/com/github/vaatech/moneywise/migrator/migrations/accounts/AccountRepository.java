package com.github.vaatech.moneywise.migrator.migrations.accounts;

import com.github.vaatech.moneywise.migrator.util.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends BaseRepository<Account, Integer> {}
