package com.onnovacion.onnovacion.domain.movements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.onnovacion.onnovacion.domain.accounts.Account;

@Entity
@Table(name = "MOVEMENT")
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ONNOVACION_MOVEMENT_id_seq")
    @SequenceGenerator(name="ONNOVACION_MOVEMENT_id_seq", sequenceName = "ONNOVACION.MOVEMENT_id_seq", allocationSize=1)
    @Column(name = "ID")
    private int id;

    @Column(name = "VALUE")
    private int value;

    @ManyToOne(fetch = FetchType.EAGER)
    private Account cuenta;
}
