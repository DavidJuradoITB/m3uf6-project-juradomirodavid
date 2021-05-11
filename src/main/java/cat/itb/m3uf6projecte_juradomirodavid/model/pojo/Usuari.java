package cat.itb.m3uf6projecte_juradomirodavid.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Usuari {

    @Id
    private String username;
    private String password;
    private String rol;

    public Usuari(String username, String password) {
        this.username = username;
        this.password = new BCryptPasswordEncoder().encode(password);
        if (this.rol == null) this.rol = "USER";
    }

//    He hagut d'eliminar la anotació de AllArgsConstructor per a poder crear aquest constructor necessari per al meu programa
    public Usuari(String username, String password, String rol) {
        this.username = username;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.rol = rol;
    }
}
