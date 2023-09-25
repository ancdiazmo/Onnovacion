package com.onnovacion.onnovacion.infraestructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onnovacion.onnovacion.application.services.interfaces.IMovementService;
import com.onnovacion.onnovacion.domain.movements.dtos.MovementDTO;

@RestController
@RequestMapping("MovementController")
public class MovementController {
    
    @Autowired
    private IMovementService movementService;

    @GetMapping("/getAll")
    public List<MovementDTO> getAll () {
        return movementService.getAll();
    }

    @PostMapping("/addMovement")
    public ResponseEntity<MovementDTO> addMovement (@RequestBody MovementDTO movementDTO) {
        return movementService.addMovement(movementDTO);
    }
}
