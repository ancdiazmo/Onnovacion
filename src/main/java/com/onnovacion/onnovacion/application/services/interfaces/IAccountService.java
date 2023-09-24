package com.onnovacion.onnovacion.application.services.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.onnovacion.onnovacion.domain.accounts.dtos.AccountDTO;

public interface IAccountService {
    
    public List<AccountDTO> getAll();

    public ResponseEntity<AccountDTO> addAccount(AccountDTO accountDTO);
}
