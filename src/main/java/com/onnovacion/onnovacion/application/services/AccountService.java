package com.onnovacion.onnovacion.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onnovacion.onnovacion.application.services.interfaces.IAccountService;
import com.onnovacion.onnovacion.domain.accounts.Account;
import com.onnovacion.onnovacion.domain.accounts.dtos.AccountDTO;
import com.onnovacion.onnovacion.domain.accounts.mappers.AccountMapper;
import com.onnovacion.onnovacion.infraestructure.resporitories.IAccountRepository;

@Service
public class AccountService implements IAccountService {

    private final IAccountRepository accountRepository;

    @Autowired
    public AccountService (IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDTO> getAll() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountDTO> accountsDTO = new ArrayList<>();
        for (Account account : accounts) {
            accountsDTO.add(AccountMapper.accountMapper.entityToDTO(account));
        }
        return accountsDTO;
    }

    @Override
    public ResponseEntity<AccountDTO> addAccount(AccountDTO accountDTO) {
        try {
            Account saved = accountRepository.save(AccountMapper.accountMapper.DTOtoEntity(accountDTO));
            return new ResponseEntity<>(AccountMapper.accountMapper.entityToDTO(saved), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new AccountDTO (), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
