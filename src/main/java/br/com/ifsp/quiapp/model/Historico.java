package br.edu.ifsp.javafx.aulas.model;

public interface Historico {
    public static final double numPerguntaPorRodada=10;
    public void jogadasDoUsuario(Jogadas jogadaAtual);
    public void mostrarDados();
}
