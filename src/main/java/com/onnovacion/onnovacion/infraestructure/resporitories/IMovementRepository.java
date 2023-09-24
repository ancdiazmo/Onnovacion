package com.onnovacion.onnovacion.infraestructure.resporitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onnovacion.onnovacion.domain.movements.Movement;

@Repository
public interface IMovementRepository extends JpaRepository<Movement, Integer>{
    
}
