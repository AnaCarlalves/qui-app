package br.edu.ifsp.javafx.aulas.model;

//falta um metodo abstrato

public abstract class Perguntas {
    public String pergunta;
    public String respostaCerta;
    public String[] outrasAlternativas;
    public boolean verificaAcerto; // se retornar true é porque acertou a pergunta, se retornar false é porque errou

    public Perguntas() {
    }

    public Perguntas(String pergunta, String respostaCerta, String[] outrasAlternativas) {
        this.pergunta = pergunta;
        this.respostaCerta = respostaCerta;
        this.outrasAlternativas = outrasAlternativas;
    }

    public Perguntas(String pergunta) {
        this.pergunta = pergunta;
        this.outrasAlternativas = new String[4];
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getRespostaCerta() {
        return respostaCerta;
    }

    public void setRespostaCerta(String respostaCerta) {
        this.respostaCerta = respostaCerta;
    }

    public String[] getOutrasAlternativas() {
        return outrasAlternativas;
    }

    public void setOutrasAlternativas(String[] outrasAlternativas) {
        this.outrasAlternativas = outrasAlternativas;
    }

    public boolean isVerificaAcerto() {
        return verificaAcerto;
    }

    public void setVerificaAcerto(boolean verificaAcerto) {
        this.verificaAcerto = verificaAcerto;
    }

    public void criarPergunta() {

    }
    
    public abstract void definirRespostaCerta(String respostaCerta);
    public abstract void adicionaAlternativa(String value, int indice);
}
