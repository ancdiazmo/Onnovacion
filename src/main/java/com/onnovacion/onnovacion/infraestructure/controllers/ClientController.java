package com.onnovacion.onnovacion.infraestructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onnovacion.onnovacion.application.services.interfaces.IClientService;
import com.onnovacion.onnovacion.domain.clients.dtos.ClientDTO;

@RestController
@RequestMapping("ClientController")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @GetMapping("/getAll")
    public List<ClientDTO> getAll () {
        return clientService.getAll();
    }

    @PostMapping("/addClient")
    public ResponseEntity<ClientDTO> addClient (@RequestBody ClientDTO clientDTO) {
        return clientService.addClient(clientDTO);
    }
    
}
