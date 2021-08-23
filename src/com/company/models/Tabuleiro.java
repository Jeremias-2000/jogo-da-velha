package com.company.models;

import java.util.HashMap;
import java.util.Map;

public class Tabuleiro {

    //verifica se esta correto
    private Map<Coordenada,Character> jogadaMap;
    private char [][] tabuleiro;





    public  Tabuleiro() {
        jogadaMap = new HashMap<>();
        tabuleiro = new char[3][3];
    }

    public void mostraTabuleiro(char[][] tabuleiro){
        System.out.println("\n-----Tabuleiro-----");
        System.out.println(" \n     0      1     2   \n");
        System.out.printf("0 \t %c  |  %c  |  %c \n",tabuleiro[0][0],tabuleiro[0][1],tabuleiro[0][2]);
        System.out.printf("    ------------------\n");
        System.out.printf("1 \t %c  |  %c  |  %c \n",tabuleiro[1][0],tabuleiro[1][1],tabuleiro[1][2]);
        System.out.printf("    ------------------\n");
        System.out.printf("2  \t %c  |  %c  |  %c \n\n",tabuleiro[2][0],tabuleiro[2][1],tabuleiro[2][2]);
    }

    public Map<Coordenada, Character> getJogadaMap() {
        return jogadaMap;
    }

    public void setJogadaMap(Map<Coordenada, Character> jogadaMap) {
        this.jogadaMap = jogadaMap;
    }

    public char[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(char[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

}
