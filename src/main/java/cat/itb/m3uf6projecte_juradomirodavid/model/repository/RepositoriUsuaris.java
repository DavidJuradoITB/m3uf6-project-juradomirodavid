package cat.itb.m3uf6projecte_juradomirodavid.model.repository;

import cat.itb.m3uf6projecte_juradomirodavid.model.pojo.Usuari;
import org.springframework.data.repository.CrudRepository;

public interface RepositoriUsuaris extends CrudRepository<Usuari, String> {

    Usuari findByUsername(String username);

}
