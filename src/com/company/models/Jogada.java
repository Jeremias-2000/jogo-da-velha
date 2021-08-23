package com.company.models;

import java.util.Scanner;

public class Jogada {
    private Character simbolo;
    private Coordenada coordenada;
    Scanner sc = new Scanner(System.in);


    public Jogada(char simbolo, Coordenada coordenada) {
        this.simbolo = simbolo;
        this.coordenada = coordenada;
    }


    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

}
