package com.onnovacion.onnovacion.application.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.onnovacion.onnovacion.application.services.interfaces.IAccountService;
import com.onnovacion.onnovacion.domain.accounts.Account;
import com.onnovacion.onnovacion.domain.clients.Client;
import com.onnovacion.onnovacion.domain.clients.dtos.ClientDTO;
import com.onnovacion.onnovacion.domain.clients.enums.ClientType;
import com.onnovacion.onnovacion.domain.clients.enums.DocumentType;
import com.onnovacion.onnovacion.infraestructure.resporitories.IAccountRepository;

public class AccountServiceTest {

    @Mock
    private IAccountRepository accountRepository;
    private IAccountService accountService;
    
    @BeforeEach
    public void init () {
        MockitoAnnotations.openMocks(this);
        accountService = new AccountService (accountRepository);
    }
}
