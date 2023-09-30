package br.com.ifsp.quiapp.model;

import java.util.ArrayList;

import org.springframework.stereotype.Indexed;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario  implements Historico{
    @OneToMany(mappedBy = "usuario")
    private ArrayList<Jogadas> jogadasDoUsuario = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuarios;
    private String nome;
    private int acertosTotais;
    private int errosTotais;
    private String tipo;
    

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

    public Long getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Long idUsuarios) {
        this.idUsuarios = idUsuarios;
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

    // @Override
    // public void jogadasDoUsuario(Jogadas jogadaAtual) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'jogadasDoUsuario'");
    // }

    // @Override
    // public void mostrarDados() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'mostrarDados'");
    // }

    // @Override
    // public void deletarHistorico() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'deletarHistorico'");
    // }

    public void setErrosTotais(int errosTotais) {
        this.errosTotais = errosTotais;
    }

    public ArrayList<Jogadas> getJogadasDoUsuario() {
        return jogadasDoUsuario;
    }

    public void setJogadasDoUsuario(ArrayList<Jogadas> jogadasDoUsuario) {
        this.jogadasDoUsuario = jogadasDoUsuario;
         int acertos =0;
         int erros =0;

        for (int i = 0; i< jogadasDoUsuario.size(); i++){
            acertos = acertos + jogadasDoUsuario.get(i).getNumAcertosJogada();
            erros = erros + jogadasDoUsuario.get(i).getNumErroJogada();

        }

        this.acertosTotais = acertos;
        this.errosTotais = erros;
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
        this.jogadasDoUsuario.clear();
    }

    public Boolean deletarJogada(int numJogada){
        if(numJogada >= jogadasDoUsuario.size() || numJogada < 0){
            return false;
        }
        else{
            jogadasDoUsuario.remove(numJogada);
            
            if(jogadasDoUsuario.isEmpty() == true){
                this.acertosTotais =0;
                this.errosTotais =0;
            }
            else{
                this.acertosTotais = this.acertosTotais - jogadasDoUsuario.get(numJogada).getNumAcertosJogada();
                this.errosTotais = this.errosTotais - jogadasDoUsuario.get(numJogada).getNumErroJogada();
            }

            return true;
        }
    }

}