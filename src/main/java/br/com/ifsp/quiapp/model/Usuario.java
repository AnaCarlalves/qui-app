package br.com.ifsp.quiapp.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Indexed;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario  implements Historico{
    @OneToMany(mappedBy = "usuario")
    private List<Jogadas> jogadasDoUsuario = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuarios;
    private String username;
    private String password;
    private int acertosTotais;
    private int errosTotais;
    private String tipo;
    

    public Usuario() {
    }

    public Usuario(String username) {
        this.username = username;
    }

        public Usuario(int acertosTotais, int errosTotais) {
        this.acertosTotais = acertosTotais;
        this.errosTotais = errosTotais;
    }

    public Usuario(String username, int acertosTotais, int errosTotais) {
        this.username = username;
        this.acertosTotais = acertosTotais;
        this.errosTotais = errosTotais;
    }

    
    public Usuario(String username, String tipo) {
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String nome) {
        this.username = username;
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

    
    public List<Jogadas> getJogadasDoUsuario() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    // public Boolean deletarJogada(int numJogada){
    //     // if(numJogada >= jogadasDoUsuario.size() || numJogada < 0){
    //     //     return false;
    //     // }
    //     // else{
    //     //     jogadasDoUsuario.remove(numJogada);
            
    //     //     if(jogadasDoUsuario.isEmpty() == true){
    //     //         this.acertosTotais =0;
    //     //         this.errosTotais =0;
    //     //     }
    //     //     else{
    //     //         this.acertosTotais = this.acertosTotais - jogadasDoUsuario.get(numJogada).getNumAcertosJogada();
    //     //         this.errosTotais = this.errosTotais - jogadasDoUsuario.get(numJogada).getNumErroJogada();
    //     //     }

    //     //     return true;
    //     // }


    // }


}