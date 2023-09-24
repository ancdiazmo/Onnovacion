package com.onnovacion.onnovacion.application.services.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.onnovacion.onnovacion.domain.clients.dtos.ClientDTO;

public interface IClientService {

    public List<ClientDTO> getAll();

    public ResponseEntity<ClientDTO> addClient(ClientDTO clientDTO);
    
}
