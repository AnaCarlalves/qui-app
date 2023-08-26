package br.edu.ifsp.javafx.aulas;

import java.util.ArrayList;

import br.edu.ifsp.javafx.aulas.model.PerguntaVestibular;
import br.edu.ifsp.javafx.aulas.model.Perguntas;
import br.edu.ifsp.javafx.aulas.model.Usuario;

public class Tabela {
    private ArrayList<Usuario> bancoUsuarios;
    private ArrayList<Perguntas> bancoPerguntas;

    public Tabela() {
        bancoUsuarios = new ArrayList<>();
        bancoPerguntas = new ArrayList<>();
    }

    
    public void init(){
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        bancoUsuarios.add(new Usuario("Joao"));
        
        
        
        bancoPerguntas.add(new PerguntaVestibular(null));
    }
    
    public void addUsuario(Usuario novo){
        bancoUsuarios.add(novo);
    }

    public void addPerguntas(Perguntas novo){
        bancoPerguntas.add(novo);
    }

    public void removerUsuario(Usuario usuario) {
    bancoUsuarios.remove(usuario);
}


    public ArrayList<Usuario> recuperaDadoUsuario(){
        return bancoUsuarios;
    }

    public ArrayList<Perguntas> recuperaDadoPerguntas(){
        return bancoPerguntas;
    }

}