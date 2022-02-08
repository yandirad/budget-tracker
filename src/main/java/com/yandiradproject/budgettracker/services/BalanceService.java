package com.yandiradproject.budgettracker.services;

import com.yandiradproject.budgettracker.repositories.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author yandirad
 */
@Service
public class BalanceService {
    
    @Autowired
    private BalanceRepository balanceRepository;


}
