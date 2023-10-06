package br.com.ifsp.quiapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idPergunta;
    protected String nivelDificuldade;
    protected String pergunta;
    protected String alternativaA;
    protected String alternativaB;
    protected String alternativaC;
    protected String alternativaD;
    protected String respostaCerta;

    public Pergunta() {

    }

    public Pergunta(String nivelDificuldade, String pergunta, String alternativaA,
            String alternativaB, String alternativaC, String alternativaD, String respostaCerta) {
        this.nivelDificuldade = nivelDificuldade;
        this.pergunta = pergunta;
        this.alternativaA = alternativaA;
        this.alternativaB = alternativaB;
        this.alternativaC = alternativaC;
        this.alternativaD = alternativaD;
        this.respostaCerta = respostaCerta;
    }

    // public void addDado(DatabasePergunta databasePerguntas){
    // databasePerguntas.perguntas.add(this);
    // }

    public Long getidPergunta() {
        return idPergunta;
    }

    public void setidPergunta(Long idPergunta) {
        this.idPergunta = idPergunta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getAlternativaA() {
        return alternativaA;
    }

    public void setAlternativaA(String alternativaA) {
        this.alternativaA = alternativaA;
    }

    public String getAlternativaB() {
        return alternativaB;
    }

    public void setAlternativaB(String alternativaB) {
        this.alternativaB = alternativaB;
    }

    public String getAlternativaC() {
        return alternativaC;
    }

    public void setAlternativaC(String alternativaC) {
        this.alternativaC = alternativaC;
    }

    public String getAlternativaD() {
        return alternativaD;
    }

    public void setAlternativaD(String alternativaD) {
        this.alternativaD = alternativaD;
    }

    public String getRespostaCerta() {
        return respostaCerta;
    }

    public void setRespostaCerta(String respostaCerta) {
        this.respostaCerta = respostaCerta;
    }

    public String getNivelDificuldade() {
        return nivelDificuldade;
    }

    public void setNivelDificuldade(String nivelDificuldade) {
        this.nivelDificuldade = nivelDificuldade;
    }

}