package com.onnovacion.onnovacion.domain.accounts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.onnovacion.onnovacion.domain.clients.Client;
import com.onnovacion.onnovacion.domain.accounts.enums.Currency;

@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ONNOVACION_ACCOUNT_id_seq")
    @SequenceGenerator(name="ONNOVACION_ACCOUNT_id_seq", sequenceName = "ACCOUNT_id_seq", allocationSize=1)
    @Column(name = "ID")
    private int id;

    @Column(name = "CURRENCY")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(name = "VALUE")
    private int value;

    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    public Account() {

    }

    public Account(int id, Currency currency, int value, Client client) {
        this.id = id;
        this.currency = currency;
        this.value = value;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", currency=" + currency + ", value=" + value + ", client=" + client + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((currency == null) ? 0 : currency.hashCode());
        result = prime * result + value;
        result = prime * result + ((client == null) ? 0 : client.hashCode());
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
        Account other = (Account) obj;
        if (id != other.id)
            return false;
        if (currency != other.currency)
            return false;
        if (value != other.value)
            return false;
        if (client == null) {
            if (other.client != null)
                return false;
        } else if (!client.equals(other.client))
            return false;
        return true;
    }
    
}
