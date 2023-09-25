package com.onnovacion.onnovacion.application.services.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.onnovacion.onnovacion.domain.movements.dtos.MovementDTO;

public interface IMovementService {
    
    public List<MovementDTO> getAll();

    public ResponseEntity<MovementDTO> addMovement(MovementDTO accountDTO);
}
