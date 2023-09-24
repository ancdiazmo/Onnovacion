package com.onnovacion.onnovacion.application.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;

import com.onnovacion.onnovacion.application.services.interfaces.IClientService;
import com.onnovacion.onnovacion.domain.clients.Client;
import com.onnovacion.onnovacion.domain.clients.dtos.ClientDTO;
import com.onnovacion.onnovacion.domain.clients.enums.ClientType;
import com.onnovacion.onnovacion.domain.clients.enums.DocumentType;
import com.onnovacion.onnovacion.infraestructure.resporitories.IClientRepository;

public class ClientServiceTest {

    @Mock
    private IClientRepository clientRepository;
    private IClientService clienteService;
    
    @BeforeEach
    public void init () {
        MockitoAnnotations.openMocks(this);
        clienteService = new ClientService (clientRepository);
    }
    
    @Test
    public void getAllTest() {
        //Arrange
        List<Client> clients = new ArrayList<> ();
        clients.add(new Client(1, "JUAN", "MARTINEZ", DocumentType.CC, "1026150352", "30.686.957-X", null, null, ClientType.N));
        clients.add(new Client(2, "JUAN", "MARTINEZ", DocumentType.CC, "1026150352", "30.686.957-Z", null, null, ClientType.N));
        clients.add(new Client(3, null, null, null, null,"30.686.957-C","ONNOVACION.SAS", 2018, ClientType.J));
        clients.add(new Client(4, null, null, null, null,"30.686.957-E","ONNOVACION2.SAS", 2019, ClientType.J));
        Mockito.when(clientRepository.findAll()).thenReturn(clients);
        //Act
        List<ClientDTO> clientsDTO = clienteService.getAll();
        //Assert
        Assertions.assertNotNull(clientsDTO);
        Mockito.verify(clientRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void addClientNaturalTest () {
        //Arrange
        Client client = new Client (1, "JUAN", "MARTINEZ", DocumentType.CC, "1026150352", "30.686.957-X", null, null, ClientType.N);
        ClientDTO clientDTO = new ClientDTO (1, "JUAN", "MARTINEZ", DocumentType.CC, "1026150352", "30.686.957-X", null, null, ClientType.N);
        Mockito.when(clientRepository.validateFieldsInsertOnClient(
            clientDTO.getId(),
            clientDTO.getName(), 
            clientDTO.getLastName(), 
            clientDTO.getDocumentType().toString(), 
            clientDTO.getDocumentNumber(), 
            clientDTO.getRut(), 
            clientDTO.getSocialReason(), 
            clientDTO.getFundationYear(), 
            clientDTO.getClientType().toString())).thenReturn("TRUE");
        Mockito.when(clientRepository.save(Mockito.any(Client.class))).thenReturn(client);
        //Act
        ResponseEntity<ClientDTO> actual = clienteService.addClient(clientDTO);
        //Assert
        Assertions.assertNotNull(actual);
        Mockito.verify(clientRepository, Mockito.times(1)).validateFieldsInsertOnClient(clientDTO.getId(),
            clientDTO.getName(), 
            clientDTO.getLastName(), 
            clientDTO.getDocumentType().toString(), 
            clientDTO.getDocumentNumber(), 
            clientDTO.getRut(), 
            clientDTO.getSocialReason(), 
            clientDTO.getFundationYear(), 
            clientDTO.getClientType().toString());
        Mockito.verify(clientRepository, Mockito.times(1)).save(Mockito.any(Client.class));
    }

    @Test
    public void addClientJuridicoTest () {
        //Arrange
        Client client = new Client (3, null, null, null, null,"30.686.957-C","ONNOVACION.SAS", 2018, ClientType.J);
        ClientDTO clientDTO = new ClientDTO (3, null, null, null, null,"30.686.957-C","ONNOVACION.SAS", 2018, ClientType.J);
        Mockito.when(clientRepository.validateFieldsInsertOnClient(
            clientDTO.getId(),
            clientDTO.getName(), 
            clientDTO.getLastName(), 
            clientDTO.getDocumentType() != null? clientDTO.getDocumentType().toString() : null, 
            clientDTO.getDocumentNumber(), 
            clientDTO.getRut(), 
            clientDTO.getSocialReason(), 
            clientDTO.getFundationYear(), 
            clientDTO.getClientType().toString())).thenReturn("TRUE");
        Mockito.when(clientRepository.save(Mockito.any(Client.class))).thenReturn(client);
        //Act
        ResponseEntity<ClientDTO> actual = clienteService.addClient(clientDTO);
        //Assert
        Assertions.assertNotNull(actual);
        Mockito.verify(clientRepository, Mockito.times(1)).validateFieldsInsertOnClient(clientDTO.getId(),
            clientDTO.getName(), 
            clientDTO.getLastName(), 
            clientDTO.getDocumentType() != null? clientDTO.getDocumentType().toString() : null,  
            clientDTO.getDocumentNumber(), 
            clientDTO.getRut(), 
            clientDTO.getSocialReason(), 
            clientDTO.getFundationYear(), 
            clientDTO.getClientType().toString());
        Mockito.verify(clientRepository, Mockito.times(1)).save(Mockito.any(Client.class));
    }

    @Test
    public void addClientJuridicoExceptionTest () {
        //Arrange
        ClientDTO clientDTO = new ClientDTO (3, null, null, null, null,"30.686.957-C","ONNOVACION.SAS", 2018, ClientType.J);
        Mockito.when(clientRepository.validateFieldsInsertOnClient(
            clientDTO.getId(),
            clientDTO.getName(), 
            clientDTO.getLastName(), 
            clientDTO.getDocumentType() != null? clientDTO.getDocumentType().toString() : null, 
            clientDTO.getDocumentNumber(), 
            clientDTO.getRut(), 
            clientDTO.getSocialReason(), 
            clientDTO.getFundationYear(), 
            clientDTO.getClientType().toString())).thenReturn("TRUE");
        Mockito.when(clientRepository.save(Mockito.any(Client.class))).thenThrow(new DataIntegrityViolationException (""));
        //Act
        ResponseEntity<ClientDTO> actual = clienteService.addClient(clientDTO);
        //Assert
        Assertions.assertNotNull(actual);
        Mockito.verify(clientRepository, Mockito.times(1)).validateFieldsInsertOnClient(clientDTO.getId(),
            clientDTO.getName(), 
            clientDTO.getLastName(), 
            clientDTO.getDocumentType() != null? clientDTO.getDocumentType().toString() : null,  
            clientDTO.getDocumentNumber(), 
            clientDTO.getRut(), 
            clientDTO.getSocialReason(), 
            clientDTO.getFundationYear(), 
            clientDTO.getClientType().toString());
        Mockito.verify(clientRepository, Mockito.times(1)).save(Mockito.any(Client.class));
    }

    @Test
    public void addClientJuridicoBadRequestTest () {
        //Arrange
        ClientDTO clientDTO = new ClientDTO (3, null, null, null, null,"30.686.957-C","ONNOVACION.SAS", 2018, ClientType.N);
        Mockito.when(clientRepository.validateFieldsInsertOnClient(
            clientDTO.getId(),
            clientDTO.getName(), 
            clientDTO.getLastName(), 
            clientDTO.getDocumentType() != null? clientDTO.getDocumentType().toString() : null, 
            clientDTO.getDocumentNumber(), 
            clientDTO.getRut(), 
            clientDTO.getSocialReason(), 
            clientDTO.getFundationYear(), 
            clientDTO.getClientType().toString())).thenReturn("FALSE");
        Mockito.when(clientRepository.save(Mockito.any(Client.class))).thenThrow(new DataIntegrityViolationException (""));
        //Act
        ResponseEntity<ClientDTO> actual = clienteService.addClient(clientDTO);
        //Assert
        Assertions.assertNotNull(actual);
        Mockito.verify(clientRepository, Mockito.times(1)).validateFieldsInsertOnClient(clientDTO.getId(),
            clientDTO.getName(), 
            clientDTO.getLastName(), 
            clientDTO.getDocumentType() != null? clientDTO.getDocumentType().toString() : null,  
            clientDTO.getDocumentNumber(), 
            clientDTO.getRut(), 
            clientDTO.getSocialReason(), 
            clientDTO.getFundationYear(), 
            clientDTO.getClientType().toString());
    }
}
