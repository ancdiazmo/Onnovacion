package com.onnovacion.onnovacion.infraestructure.resporitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onnovacion.onnovacion.domain.accounts.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer>{
    
}
