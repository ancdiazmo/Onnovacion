package com.onnovacion.onnovacion.domain.movements.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.onnovacion.onnovacion.domain.movements.Movement;
import com.onnovacion.onnovacion.domain.movements.dtos.MovementDTO;

@Mapper
public interface MovementMapper {
    
    MovementMapper movementMapper = Mappers.getMapper(MovementMapper.class);
    
    Movement DTOtoEntity (MovementDTO movementDTO);

    MovementDTO entityToDTO (Movement movementent);
}
