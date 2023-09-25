package com.onnovacion.onnovacion.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onnovacion.onnovacion.application.services.interfaces.IMovementService;
import com.onnovacion.onnovacion.domain.movements.Movement;
import com.onnovacion.onnovacion.domain.movements.dtos.MovementDTO;
import com.onnovacion.onnovacion.domain.movements.mappers.MovementMapper;
import com.onnovacion.onnovacion.infraestructure.resporitories.IMovementRepository;

@Service
public class MovementService implements IMovementService {

    private final IMovementRepository movementRepository;

    @Autowired
    public MovementService (IMovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    @Override
    public List<MovementDTO> getAll() {
        List<Movement> movements = movementRepository.findAll();
        List<MovementDTO> movementsDTO = new ArrayList<>();
        for (Movement movement : movements) {
            movementsDTO.add(MovementMapper.movementMapper.entityToDTO(movement));
        }
        return movementsDTO;
    }

    @Override
    public ResponseEntity<MovementDTO> addMovement(MovementDTO movementDTO) {
        String result = movementRepository.validateAccountValueAfterMovement(movementDTO.getValue(),
            String.valueOf(movementDTO.getAccount().getId()));

        if (result.equals("TRUE")) {
            try {
                int savedId = movementRepository.save(MovementMapper.movementMapper.DTOtoEntity(movementDTO)).getId();
                movementRepository.udpateAccountValueAfterMovement(movementDTO.getValue(), String.valueOf(movementDTO.getAccount().getId()));
                Movement savedWithField = movementRepository.findById(savedId).orElse(null);
                return new ResponseEntity<>(MovementMapper.movementMapper.entityToDTO(savedWithField), HttpStatus.OK);
            } catch (DataIntegrityViolationException e) {
                e.printStackTrace();
                return new ResponseEntity<>(new MovementDTO (), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(new MovementDTO (), HttpStatus.BAD_REQUEST);
    }
    
}
