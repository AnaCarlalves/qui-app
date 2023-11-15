package br.com.ifsp.quiapp.repository;
import org.springframework.data.repository.CrudRepository;
import br.com.ifsp.quiapp.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}