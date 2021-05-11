package cat.itb.m3uf6projecte_juradomirodavid.model.service;

import cat.itb.m3uf6projecte_juradomirodavid.model.pojo.Usuari;
import cat.itb.m3uf6projecte_juradomirodavid.model.repository.RepositoriUsuaris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;


@Service
public class ServeiUsuari {

    @Autowired
    private RepositoriUsuaris repo;

    public void afegirUsuari(Usuari data) {
        Usuari constructed = new Usuari(data.getUsername(), data.getPassword());

        repo.save(constructed);
        System.out.println("Usuari afegit: [" + constructed + "] satisfactioriament.");
    }

    @PostConstruct
    public void init() {
        repo.save(new Usuari("admin", "admin", "ADMIN"));
        repo.save(new Usuari("user", "user", "USER"));
    }

}
