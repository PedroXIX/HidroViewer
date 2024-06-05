/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author Pedro
 */
public class Funcionario {
    private int codFuncionario;
    private String nomeFuncionario,
    cpfFuncionario,
    senhaFuncionario,
    emailFuncionario,
    telefoneFuncionario;

    public Funcionario() {
    }

    public Funcionario(int codFuncionario, String nomeFuncionario, String cpfFuncionario, String senhaFuncionario, String emailFuncionario, String telefoneFuncionario) {
        this.codFuncionario = codFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.cpfFuncionario = cpfFuncionario;
        this.senhaFuncionario = senhaFuncionario;
        this.emailFuncionario = emailFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public String getSenhaFuncionario() {
        return senhaFuncionario;
    }

    public String getEmailFuncionario() {
        return emailFuncionario;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public void setSenhaFuncionario(String senhaFuncionario) {
        this.senhaFuncionario = senhaFuncionario;
    }

    public void setEmailFuncionario(String emailFuncionario) {
        this.emailFuncionario = emailFuncionario;
    }

    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

    @Override
    public String toString() {
        return "FuncionarioModel{" + "codFuncionario=" + codFuncionario + ", nomeFuncionario=" + nomeFuncionario + ", cpfFuncionario=" + cpfFuncionario + ", senhaFuncionario=" + senhaFuncionario + ", emailFuncionario=" + emailFuncionario + ", telefoneFuncionario=" + telefoneFuncionario + '}';
    }
    
}
