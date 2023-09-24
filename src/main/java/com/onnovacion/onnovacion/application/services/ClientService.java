package com.onnovacion.onnovacion.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onnovacion.onnovacion.application.services.interfaces.IClientService;
import com.onnovacion.onnovacion.domain.clients.Client;
import com.onnovacion.onnovacion.domain.clients.dtos.ClientDTO;
import com.onnovacion.onnovacion.domain.clients.mappers.ClientMapper;
import com.onnovacion.onnovacion.infraestructure.resporitories.IClientRepository;

@Service
public class ClientService implements IClientService {
    
    private final IClientRepository clientRepository;

    @Autowired
    public ClientService (IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientDTO> getAll() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDTO> clientsDTO = new ArrayList<>();
        for (Client client : clients) {
            clientsDTO.add(ClientMapper.clientMapper.entityToDTO(client));
        }
        return clientsDTO;
    }

    @Override
    public ResponseEntity<ClientDTO> addClient(ClientDTO clientDTO) {
        String result = clientRepository.validateFieldsInsertOnClient(
            clientDTO.getId(),
            clientDTO.getName(), 
            clientDTO.getLastName(), 
            clientDTO.getDocumentType() != null? clientDTO.getDocumentType().toString() : null,
            clientDTO.getDocumentNumber(), 
            clientDTO.getRut(), 
            clientDTO.getSocialReason(), 
            clientDTO.getFundationYear(), 
            clientDTO.getClientType().toString());
        if (result.equals("TRUE")) {
            try {
                Client saved = clientRepository.save(ClientMapper.clientMapper.DTOtoEntity(clientDTO));
                return new ResponseEntity<>(ClientMapper.clientMapper.entityToDTO(saved), HttpStatus.OK);
            } catch (DataIntegrityViolationException e) {
                e.printStackTrace();
                return new ResponseEntity<>(new ClientDTO (), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(new ClientDTO (), HttpStatus.BAD_REQUEST);
    }
    
}
