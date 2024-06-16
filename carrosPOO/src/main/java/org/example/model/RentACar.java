package org.example.model;

import org.example.dao.RentDAO;

import javax.swing.*;
import java.awt.*;

public class RentACar {

    private String nomeCar;
    private String dataIni;
    private String devolucao;
    private double valor;
    private String cor;
    private String placa;

    public RentACar(String nomeCar, String dataIni, String devolucao, double valor, String cor, String placa) {
        this.nomeCar = nomeCar;
        this.dataIni = dataIni;
        this.devolucao = devolucao;
        this.valor = valor;
        this.cor = cor;
        this.placa = placa;
    }

    public String getNomeCar() {
        return nomeCar;
    }

    public void setNomeCar(String nomeCar) {
        this.nomeCar = nomeCar;
    }

    public String getDataIni() {
        return dataIni;
    }

    public void setDataIni(String dataIni) {
        this.dataIni = dataIni;
    }

    public String getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(String devolucao) {
        this.devolucao = devolucao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
