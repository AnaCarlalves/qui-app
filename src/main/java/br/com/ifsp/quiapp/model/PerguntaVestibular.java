package br.edu.ifsp.javafx.aulas.model;


public class PerguntaVestibular extends Perguntas{

    

    public PerguntaVestibular(String pergunta) {
        super(pergunta);
    }

    @Override
    public void criarPergunta() {
        super.criarPergunta();
    }

    @Override
    public void definirRespostaCerta(String  respostaCerta) {
        super.setRespostaCerta(respostaCerta);
    }

    //mudar no perguntas esse metodo
    @Override
    public void adicionaAlternativa(String value, int indice) {
        this.outrasAlternativas[indice] = value;
    }

}