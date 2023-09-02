package br.com.ifsp.quiapp.model;

import java.util.ArrayList;

public class Usuario  implements Historico{
    private String nome;
    private int acertosTotais;
    private int errosTotais;
    private String tipo;
    private ArrayList<Jogadas> jogadasDoUsuario = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nome) {
        this.nome = nome;
    }

        public Usuario(int acertosTotais, int errosTotais) {
        this.acertosTotais = acertosTotais;
        this.errosTotais = errosTotais;
    }

    public Usuario(String nome, int acertosTotais, int errosTotais) {
        this.nome = nome;
        this.acertosTotais = acertosTotais;
        this.errosTotais = errosTotais;
    }

    
    public Usuario(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getTipo() {
        if (tipo != null) {
            return tipo;
        } else {
            return "";
        }    
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAcertosTotais() {
        return acertosTotais;
    }

    public void setAcertosTotais(int acertosTotais) {
        this.acertosTotais = acertosTotais;
    }

    public int getErrosTotais() {
        return errosTotais;
    }

    public void setErrosTotais(int errosTotais) {
        this.errosTotais = errosTotais;
    }

    public ArrayList<Jogadas> getJogadasDoUsuario() {
        return jogadasDoUsuario;
    }

    public void setJogadasDoUsuario(ArrayList<Jogadas> jogadasDoUsuario) {
        this.jogadasDoUsuario = jogadasDoUsuario;
    }



    @Override
    public void jogadasDoUsuario(Jogadas jogadaAtual) {
    
        acertosTotais = acertosTotais + jogadaAtual.getNumAcertosJogada();
        errosTotais = errosTotais + jogadaAtual.getNumErroJogada();

        jogadasDoUsuario.add(jogadaAtual);        
    }

    @Override
    public void mostrarDados() {
        for(int i=0; i < jogadasDoUsuario.size();i++){
            System.out.println("jogada: "+i+" || "+"numero de acertos: "+jogadasDoUsuario.get(i).getNumAcertosJogada()+" || "+"numero de erros: "+jogadasDoUsuario.get(i).getNumErroJogada());
        }        
    }

    @Override
    public void deletarHistorico() {
        // jogadasDoUsuario.remove(idUsuarios);        
        jogadasDoUsuario = new ArrayList<>(); 
    }

}