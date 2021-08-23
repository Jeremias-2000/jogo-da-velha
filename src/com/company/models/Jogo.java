package com.company.models;

import com.company.exceptions.ExcecaoPorCoordenadaInvalida;
import com.company.exceptions.ExcecaoPorSimboloInvalido;

import java.util.InputMismatchException;
import java.util.Map;


public class Jogo {

    private static Jogo instance;

    private Tabuleiro tabuleiroMap;
    private char [][] tabuleiroMostrar;
    private Coordenada coordenada;
    public Jogador jogador;
    private int jogadas ,vez;
    private boolean vencedor;



    public static Jogo getInstance() {
        if(instance == null){
            instance = new Jogo();
        }
        return instance;
    }



    public void init() {
        tabuleiroMostrar = new char[3][3];
        tabuleiroMap = new Tabuleiro();
        jogador = new Jogador();
        coordenada = new Coordenada();
        jogadas =0;
        vez = 0;
        vencedor = false;

    }
    public void jogar() throws ExcecaoPorSimboloInvalido, ExcecaoPorCoordenadaInvalida {
        init();
        System.out.println("-=-=-=-=-=--=-=-=-=-===-=-=-=-===-=\n" +
                "       JOGO DA VELHA       \n -=-==-=-=-=-=-=-=-=-=-=-=-==-=-=-"  );
        jogador.setJogadores(jogador.adicionaJogador());

        System.out.println("\n"+ jogador.getJogador(0)+ " e " + jogador.getJogador(1) +" estao jogando !"
                +"\n" + jogador.getJogador(0)+ " Joga com o O  e " + jogador.getJogador(1) + " com o X");

        tabuleiroMap.mostraTabuleiro(tabuleiroMostrar);
        while (jogadas<=9 && !hasWinner()){
            realizaJogada();
            tabuleiroMap.mostraTabuleiro(tabuleiroMostrar);
            trocaJogador();
            jogadas++;


        }
        if (jogadas == 9 && !hasWinner()){
            System.out.println("Deu velha");
        }else{
            vez = Math.abs(vez -1);
            System.out.printf("Parabéns %s  ,você ganhou depois de %d  jogadas",jogador.getJogador(vez),jogadas);

        }
    }



    public Map<Coordenada,Character> getBoard() {
        return tabuleiroMap.getJogadaMap();
    }

    public void realizaJogada() throws ExcecaoPorSimboloInvalido, ExcecaoPorCoordenadaInvalida {
       try {
           Coordenada co;
           char simbolo = vezJogador(vez);
           co = coordenada.pegaCoordenada();
           add(new Jogada(simbolo,co));
       }catch (InputMismatchException e){
           System.out.println(e.getMessage());
       }

    }

    public Character vezJogador(int vez){
        System.out.println("É a vez do(a):" + jogador.getJogador(vez)+ "\n");
        return vez == 0? 'O' : 'X';
    }

    public  void trocaJogador(){
        vez = (vez==0)?1:0;
    }

    public void add(Jogada o) throws ExcecaoPorCoordenadaInvalida, ExcecaoPorSimboloInvalido {

        if (check(o)){
            int linha = o.getCoordenada().getLinha();
            int coluna = o.getCoordenada().getColuna();
            tabuleiroMap.getJogadaMap().put(o.getCoordenada(),o.getSimbolo());
            tabuleiroMostrar[linha][coluna] = o.getSimbolo();
        }



    }

    public boolean check(Jogada umaJogada) throws ExcecaoPorCoordenadaInvalida ,ExcecaoPorSimboloInvalido{


        Coordenada co = umaJogada.getCoordenada();
        char simbolo = tabuleiroMostrar[co.getLinha()][co.getColuna()];
        if ((co.getLinha()< 0 || co.getLinha()>2) || (co.getColuna()<0 || co.getColuna()>2)){
            throw new ExcecaoPorCoordenadaInvalida("Foi  passada uma coordenada inválida \n");

        }
        /*else if(simbolo != 'O' && simbolo != 'X' ){
            throw new  ExcecaoPorSimboloInvalido("Simbolo informado nao e valido (so pode usar O e X) !\n");
        }*/
        else if(tabuleiroMap.getJogadaMap().containsKey(co) ){
            throw new ExcecaoPorCoordenadaInvalida("Posição já ocupada !\n");
        }
        else {
            return true;
        }

    }


    public boolean hasWinner() {

        if (tabuleiroMostrar[0][0] =='X' &&tabuleiroMostrar[0][1] =='X'&&tabuleiroMostrar[0][2] =='X'){return true;}
        if (tabuleiroMostrar[1][0] =='X' &&tabuleiroMostrar[1][1] =='X'&&tabuleiroMostrar[1][2] =='X'){return true;}
        if (tabuleiroMostrar[2][0] =='X' &&tabuleiroMostrar[2][1] =='X'&&tabuleiroMostrar[2][2] =='X'){return true;}

        if (tabuleiroMostrar[0][0] =='X' &&tabuleiroMostrar[1][0] =='X'&&tabuleiroMostrar[2][0] =='X'){return true;}
        if (tabuleiroMostrar[0][1] =='X' &&tabuleiroMostrar[1][1] =='X'&&tabuleiroMostrar[1][2] =='X'){return true;}
        if (tabuleiroMostrar[0][2] =='X' &&tabuleiroMostrar[1][2] =='X'&&tabuleiroMostrar[2][2] =='X'){return true;}

        if (tabuleiroMostrar[0][0] =='X' &&tabuleiroMostrar[1][1] =='X'&&tabuleiroMostrar[2][2] =='X'){return true;}
        if (tabuleiroMostrar[0][2] =='X' &&tabuleiroMostrar[1][1] =='X'&&tabuleiroMostrar[2][0] =='X'){return true;}



        if (tabuleiroMostrar[0][0] =='O' &&tabuleiroMostrar[0][1] =='O'&&tabuleiroMostrar[0][2] =='O'){return true;}
        if (tabuleiroMostrar[1][0] =='O' &&tabuleiroMostrar[1][1] =='O'&&tabuleiroMostrar[1][2] =='O'){return true;}
        if (tabuleiroMostrar[2][0] =='O' &&tabuleiroMostrar[2][1] =='O'&&tabuleiroMostrar[2][2] =='O'){return true;}

        if (tabuleiroMostrar[0][0] =='O' &&tabuleiroMostrar[1][0] =='O'&&tabuleiroMostrar[2][0] =='O'){return true;}
        if (tabuleiroMostrar[0][1] =='O' &&tabuleiroMostrar[1][1] =='O'&&tabuleiroMostrar[1][2] =='O'){return true;}
        if (tabuleiroMostrar[0][2] =='O' &&tabuleiroMostrar[1][2] =='O'&&tabuleiroMostrar[2][2] =='O'){return true;}

        if (tabuleiroMostrar[0][0] =='O' &&tabuleiroMostrar[1][1] =='O'&&tabuleiroMostrar[2][2] =='O'){return true;}
        if (tabuleiroMostrar[0][2] =='O' &&tabuleiroMostrar[1][1] =='O'&&tabuleiroMostrar[2][0] =='O'){return true;}

        return false;

    }
}
