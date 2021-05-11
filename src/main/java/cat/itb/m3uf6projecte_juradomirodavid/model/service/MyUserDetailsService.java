package cat.itb.m3uf6projecte_juradomirodavid.model.service;

import cat.itb.m3uf6projecte_juradomirodavid.model.pojo.Usuari;
import cat.itb.m3uf6projecte_juradomirodavid.model.repository.RepositoriUsuaris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private RepositoriUsuaris repoUser;

    @Override
    public UserDetails loadUserByUsername(String primaryKey) throws UsernameNotFoundException {
//        Create POJO
        Usuari u = repoUser.findByUsername(primaryKey);

        User.UserBuilder builder = null;

        if (u != null) {
            builder = User.withUsername(primaryKey);
            builder.disabled(false);
            builder.password(u.getPassword()); //TODO xifrar amb BCrypt
            builder.roles(u.getRol());
        }
        else throw new UsernameNotFoundException("L'usuari [" + primaryKey + "] no s'ha trobat");

        return builder.build();
    }

}
