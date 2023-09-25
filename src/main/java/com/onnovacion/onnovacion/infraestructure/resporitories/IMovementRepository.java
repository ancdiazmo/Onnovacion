package com.onnovacion.onnovacion.infraestructure.resporitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onnovacion.onnovacion.domain.movements.Movement;

@Repository
public interface IMovementRepository extends JpaRepository<Movement, Integer>{

    @Procedure("ONNOVACION.FUNCTIONS.UPDATEACCOUNTVALUEAFTERMOVEMENT")
    void udpateAccountValueAfterMovement(Integer value, String account_id);
    
    @Query(nativeQuery = true, value = 
    "SELECT ONNOVACION.FUNCTIONS.VALIDATEACCOUNTVALUEAFTERMOVEMENT(:value, :account_id) FROM DUAL")
    String validateAccountValueAfterMovement(
        @Param("value") int value, 
        @Param("account_id") String account_id
    );
}
