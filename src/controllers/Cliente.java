/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author Rique
 */
public class Cliente {
    
    private int codCliente; 
    private String cpfCliente,
    nomeCliente,
    emailCliente,
    telefoneCliente;

    public Cliente() {
    }

    public Cliente(int codCliente, String cpfCliente, String nomeCliente, String emailCliente, String telefoneCliente) {
        this.codCliente = codCliente;
        this.cpfCliente = cpfCliente;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.telefoneCliente = telefoneCliente;
    }
    
    

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCLiente) {
        this.nomeCliente = nomeCLiente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codCliente=" + codCliente + ", cpfCliente=" + cpfCliente + ", nomeCLiente=" + nomeCliente + ", emailCliente=" + emailCliente + ", telefoneCliente=" + telefoneCliente + '}';
    }
    
    
}
