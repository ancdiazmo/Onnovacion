package com.onnovacion.onnovacion.infraestructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onnovacion.onnovacion.application.services.interfaces.IAccountService;
import com.onnovacion.onnovacion.domain.accounts.dtos.AccountDTO;

@RestController
@RequestMapping("AccountController")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping("/getAll")
    public List<AccountDTO> getAll () {
        return accountService.getAll();
    }

    @PostMapping("/addAccount")
    public ResponseEntity<AccountDTO> addClient (@RequestBody AccountDTO clientDTO) {
        return accountService.addAccount(clientDTO);
    }
    
}
