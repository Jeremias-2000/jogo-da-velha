package com.company.models;

import java.util.Scanner;

public class Jogador {

    private String nome;
    private String[] jogadores;

    public Jogador(){
        jogadores = new String[2];
    }

    public String[] adicionaJogador(){
        String nome;
        System.out.println("Informe o nome do primeiro jogador: ");
        nome = sc.next();
        jogadores[0] = nome;

        System.out.println("Informe o nome do segundo jogador:");
        nome = sc.next();
        jogadores[1] = nome;

        return jogadores;
    }
    public String getJogador(int posicao){
        return jogadores[posicao];
    }

    public String[] getJogadores() {
        return jogadores;
    }

    public void setJogadores(String[] jogadores) {
        this.jogadores = jogadores;
    }

    Scanner sc = new Scanner(System.in);


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
