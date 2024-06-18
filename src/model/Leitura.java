/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 * Classe responsável por mapear a entidade Leitura provinda do banco de dados, contendo seus atributos
 * @author Rique
 */
public class Leitura {
    
    private int codLeitura,
    codHidrometro;
    
    private Date dataLeitura;
    
    private double leituraAnterior,
    leituraAtual, 
    consumo,
    mediaConsumo;
   
    public Leitura() {
    }

    public Leitura(int codLeitura, int codHidrometro, Date dataLeitura, double leituraAnterior, double leituraAtual) {
        this.codLeitura = codLeitura;
        this.codHidrometro = codHidrometro;
        this.dataLeitura = dataLeitura;
        this.leituraAnterior = leituraAnterior;
        this.leituraAtual = leituraAtual;
        this.consumo = leituraAtual - leituraAnterior;
        this.mediaConsumo = consumo/30;
    }

    public int getCodLeitura() {
        return codLeitura;
    }

    public void setCodLeitura(int codLeitura) {
        this.codLeitura = codLeitura;
    }

    public int getCodHidrometro() {
        return codHidrometro;
    }

    public void setCodHidrometro(int codHidrometro) {
        this.codHidrometro = codHidrometro;
    }

    public Date getDataLeitura() {
        return dataLeitura;
    }

    public void setDataLeitura(Date dataLeitura) {
        this.dataLeitura = dataLeitura;
    }

    public double getLeituraAnterior() {
        return leituraAnterior;
    }

    public void setLeituraAnterior(double leituraAnterior) {
        this.leituraAnterior = leituraAnterior;
        this.consumo = leituraAtual - leituraAnterior;
        this.mediaConsumo = consumo/30;
    }

    public double getLeituraAtual() {
        return leituraAtual;
    }

    public void setLeituraAtual(double leituraAtual) {
        this.leituraAtual = leituraAtual;
        this.consumo = leituraAtual - leituraAnterior;
        this.mediaConsumo = consumo/30;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double getMediaConsumo() {
        return mediaConsumo;
    }

    public void setMediaConsumo(double mediaConsumo) {
        this.mediaConsumo = mediaConsumo;
    }
    
}
