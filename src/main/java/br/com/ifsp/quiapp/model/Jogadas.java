package br.edu.ifsp.javafx.aulas.model;

import java.util.Scanner;

import br.edu.ifsp.javafx.aulas.Tabela;

public class Jogadas {
    private int numAcertosJogada;
    private int numErroJogada;

    public Jogadas() {
    }

    public int getNumAcertosJogada() {
        return numAcertosJogada;
    }

    public void setNumAcertosJogada(int numAcertosJogada) {
        this.numAcertosJogada = numAcertosJogada;
    }

    public int getNumErroJogada() {
        return numErroJogada;
    }

    public void setNumErroJogada(int numErroJogada) {
        this.numErroJogada = numErroJogada;
    }

    public void mostrarPerguntas(Tabela tabela) {
        /*
                    Scanner leitor = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            boolean respostaCorreta = tabela.getBancoPerguntas().get(0).responderPergunta();

            if (respostaCorreta) {
                numAcertosJogada++;
            } else {
                numErroJogada++;
            }
        }
        */
    }    
}