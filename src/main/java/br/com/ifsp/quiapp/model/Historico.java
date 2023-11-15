package br.com.ifsp.quiapp.model;

public interface Historico {
    public static final double numPerguntaPorRodada=10;
    public void jogadasDoUsuario(Jogadas jogadaAtual);
    public void mostrarDados();
    public void deletarHistorico();
}