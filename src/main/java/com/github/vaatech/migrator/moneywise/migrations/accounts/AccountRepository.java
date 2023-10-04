package com.github.vaatech.migrator.moneywise.migrations.accounts;

import com.github.vaatech.migrator.util.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends BaseRepository<Account, Integer> {}
