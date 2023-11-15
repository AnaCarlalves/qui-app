package br.com.ifsp.quiapp.model;
import br.com.ifsp.quiapp.DatabasePergunta;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Jogadas {
    @ManyToOne
    private Usuario usuario;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJogada;
    private int numAcertosJogada;
    private int numErroJogada;

    public Jogadas() {
    }

    public Long getIdJogada() {
        return idJogada;
    }

    public void setIdJogada(Long idJogada) {
        this.idJogada = idJogada;
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

    public void setIdUsuarios(Long idUsuarios) {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}