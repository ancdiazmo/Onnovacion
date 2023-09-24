package com.onnovacion.onnovacion.infraestructure.resporitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onnovacion.onnovacion.domain.clients.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Integer>{
    
    /**@Procedure(name = "ONNOVACION.FUNCTIONS.VALIDATEFIELDSINSERTONCLIENT")
    String VALIDATEFIELDSINSERTONCLIENT (int id, String name,String lastName,
    String documentType, String documentNumber, String rut, String socialReason, 
    Integer fundationYear, String clientType);*/

    @Query(nativeQuery = true, value = 
    "SELECT ONNOVACION.FUNCTIONS.VALIDATEFIELDSINSERTONCLIENT(:id,:name,:lastName,:documentType,:documentNumber,:rut,:socialReason,:fundationYear,:clientType) FROM DUAL")
    String validateFieldsInsertOnClient(
        @Param("id") int id, 
        @Param("name") String name, 
        @Param("lastName") String lastName,
        @Param("documentType") String documentType, 
        @Param("documentNumber") String documentNumber, 
        @Param("rut") String rut, 
        @Param("socialReason") String socialReason, 
        @Param("fundationYear") Integer fundationYear, 
        @Param("clientType") String clientType
    );
}
