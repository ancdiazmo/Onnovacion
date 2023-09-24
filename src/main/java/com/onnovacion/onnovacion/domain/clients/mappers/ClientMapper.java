package com.onnovacion.onnovacion.domain.clients.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.onnovacion.onnovacion.domain.clients.Client;
import com.onnovacion.onnovacion.domain.clients.dtos.ClientDTO;

@Mapper
public interface ClientMapper {

    ClientMapper clientMapper = Mappers.getMapper(ClientMapper.class);
    
    Client DTOtoEntity (ClientDTO clientDTO);

    ClientDTO entityToDTO (Client client);
}
