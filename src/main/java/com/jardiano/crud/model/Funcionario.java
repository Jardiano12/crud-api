package com.jardiano.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {

    private long id;
    private String primeiroNome;
    private String ultimoNome;
    private String emailId;

    public Funcionario() {

    }

    public Funcionario(String primeiroNome, String ultimoNome, String emailId) {
         this.primeiroNome = primeiroNome;
         this.ultimoNome = ultimoNome;
         this.emailId = emailId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "primeiroNome", nullable = false)
    public String getPrimeiroNome() {
        return primeiroNome;
    }
    public void setPrimeiroNome(String firstName) {
        this.primeiroNome = firstName;
    }

    @Column(name = "ultimoNome", nullable = false)
    public String getUltimoNome() {
        return ultimoNome;
    }
    public void setUltimoNome(String lastName) {
        this.ultimoNome = lastName;
    }

    @Column(name = "email", nullable = false)
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

/*    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + primeiroNome + ", lastName=" + ultimoNome + ", emailId=" + emailId
       + "]";
    }*/
    @Override
    public String toString() {
        return "Funcionario [" + "id=" + id + ", primeiroNome=" + primeiroNome + ",  ultimoNome=" + ultimoNome + ",  emailId='" + emailId + ']';
    }
}
