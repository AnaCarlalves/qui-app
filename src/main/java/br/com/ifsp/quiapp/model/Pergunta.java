package br.com.ifsp.quiapp.model;

import br.com.ifsp.quiapp.DatabasePergunta;

public class Pergunta {
    protected long codigoPergunta;
    protected String pergunta;
    protected String alternativaA;
    protected String alternativaB;
    protected String alternativaC;
    protected String alternativaD;
    protected String respostaCerta;

    public Pergunta(){

    }

    public Pergunta(long codigoPergunta, String pergunta, String alternativaA, String alternativaB, String alternativaC,
            String alternativaD, String respostaCerta) {
        this.codigoPergunta = codigoPergunta;
        this.pergunta = pergunta;
        this.alternativaA = alternativaA;
        this.alternativaB = alternativaB;
        this.alternativaC = alternativaC;
        this.alternativaD = alternativaD;
        this.respostaCerta = respostaCerta;
    }

    public void addDado(DatabasePergunta databasePerguntas){
        databasePerguntas.perguntas.add(this);
    }

    public long getCodigoPergunta() {
        return codigoPergunta;
    }

    public void setCodigoPergunta(long codigoPergunta) {
        this.codigoPergunta = codigoPergunta;
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
    
    
    
}
