package com.onnovacion.onnovacion.domain.clients;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.onnovacion.onnovacion.domain.clients.enums.ClientType;
import com.onnovacion.onnovacion.domain.clients.enums.DocumentType;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ONNOVACION_CLIENT_id_seq")
    @SequenceGenerator(name="ONNOVACION_CLIENT_id_seq", sequenceName = "ONNOVACION.CLIENT_id_seq", allocationSize=1)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "DOCUMENTTYPE")
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @Column(name = "DOCUMENTNUMBER")
    private String documentNumber;
    
    @Column(name = "RUT")
    private String rut;

    @Column(name = "SOCIALREASON")
    private String socialReason;

    @Column(name = "FUNDATIONYEAR")
    private Integer fundationYear;

    @Column(name = "CLIENTTYPE")
    @Enumerated(EnumType.STRING)
    private ClientType clientType;

    public Client() {
        
    }

    public Client(int id, String name, String lastName, DocumentType documentType, String documentNumber, String rut,
            String socialReason, Integer fundationYear, ClientType clientType) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.rut = rut;
        this.socialReason = socialReason;
        this.fundationYear = fundationYear;
        this.clientType = clientType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getSocialReason() {
        return socialReason;
    }

    public void setSocialReason(String socialReason) {
        this.socialReason = socialReason;
    }

    public Integer getFundationYear() {
        return fundationYear;
    }

    public void setFundationYear(Integer fundationYear) {
        this.fundationYear = fundationYear;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", lastName=" + lastName + ", documentType=" + documentType
                + ", documentNumber=" + documentNumber + ", rut=" + rut + ", socialReason=" + socialReason
                + ", fundationYear=" + fundationYear + ", clientType=" + clientType + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((documentType == null) ? 0 : documentType.hashCode());
        result = prime * result + ((documentNumber == null) ? 0 : documentNumber.hashCode());
        result = prime * result + ((rut == null) ? 0 : rut.hashCode());
        result = prime * result + ((socialReason == null) ? 0 : socialReason.hashCode());
        result = prime * result + ((fundationYear == null) ? 0 : fundationYear.hashCode());
        result = prime * result + ((clientType == null) ? 0 : clientType.hashCode());
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
        Client other = (Client) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (documentType != other.documentType)
            return false;
        if (documentNumber == null) {
            if (other.documentNumber != null)
                return false;
        } else if (!documentNumber.equals(other.documentNumber))
            return false;
        if (rut == null) {
            if (other.rut != null)
                return false;
        } else if (!rut.equals(other.rut))
            return false;
        if (socialReason == null) {
            if (other.socialReason != null)
                return false;
        } else if (!socialReason.equals(other.socialReason))
            return false;
        if (fundationYear == null) {
            if (other.fundationYear != null)
                return false;
        } else if (!fundationYear.equals(other.fundationYear))
            return false;
        if (clientType != other.clientType)
            return false;
        return true;
    }
    
}
