package com.onnovacion.onnovacion.domain.movements.dtos;

import com.onnovacion.onnovacion.domain.accounts.Account;

public class MovementDTO {
    
    private int id;
    private int value;
    private Account account;

    public MovementDTO() {

    }

    public MovementDTO(int id, int value, Account account) {
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
        return "MovementDTO [id=" + id + ", value=" + value + ", account=" + account + "]";
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
        MovementDTO other = (MovementDTO) obj;
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
