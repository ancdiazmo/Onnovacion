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
    private Account account;

    public Movement() {

    }

    public Movement(int id, int value, Account account) {
        this.id = id;
        this.value = value;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Movement [id=" + id + ", value=" + value + ", account=" + account + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + value;
        result = prime * result + ((account == null) ? 0 : account.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Movement other = (Movement) obj;
        if (id != other.id)
            return false;
        if (value != other.value)
            return false;
        if (account == null) {
            if (other.account != null)
                return false;
        } else if (!account.equals(other.account))
            return false;
        return true;
    }
    
}
