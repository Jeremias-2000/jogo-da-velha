package com.company;

import com.company.exceptions.ExcecaoPorCoordenadaInvalida;
import com.company.exceptions.ExcecaoPorSimboloInvalido;
import com.company.models.Jogo;

public class Main {

    public static void main(String[] args) throws ExcecaoPorSimboloInvalido, ExcecaoPorCoordenadaInvalida {
	// write your code here

        Jogo jogo = Jogo.getInstance();
        jogo.jogar();
    }
}
