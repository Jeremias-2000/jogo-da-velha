package com.company.models;

import java.util.Scanner;

public class Coordenada {
    private int linha;
    private  int coluna;
    Scanner sc = new Scanner(System.in);
    public Coordenada(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public Coordenada() {
    }

    public Coordenada pegaCoordenada(){
        Coordenada coordenada = new Coordenada();
        System.out.println("Informe a linha e a coluna:");
        coordenada.setLinha(sc.nextInt());
        coordenada.setColuna(sc.nextInt());
        return coordenada;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
}
