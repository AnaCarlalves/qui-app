package br.com.ifsp.quiapp;

import java.util.ArrayList;
import java.util.List;

import br.com.ifsp.quiapp.model.Pergunta;

public class DatabasePergunta {
    public static ArrayList<Pergunta> perguntas;

    public static void init(){
        perguntas = new ArrayList<Pergunta>();
        perguntas.add(new Pergunta(1, "Qual a fórmula do cloro?", 
        "O2", "H2O", "Cl2", "N2", "Cl2"));
    }

    public void addDadoPerguntas(Pergunta novo){
        perguntas.add(novo);
    }

    public static ArrayList<Pergunta> recuperarDadoPergunta(){
        return perguntas;
    }

    public void removeDadosPergunta(Pergunta delete){
        perguntas.remove(delete);
    }
    
    public static List<Pergunta> all(){
        return perguntas;
    }
}
