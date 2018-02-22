package com.budgetplanner.balance.repository;

import org.springframework.data.repository.CrudRepository;

import com.budgetplanner.domain.BalanceCompositePK;
import com.budgetplanner.domain.BalanceDTO;

public interface BalanceRepository extends CrudRepository<BalanceDTO, BalanceCompositePK> {

}
