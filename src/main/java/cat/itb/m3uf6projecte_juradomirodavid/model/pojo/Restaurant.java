package cat.itb.m3uf6projecte_juradomirodavid.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Restaurant {

    @Id
    private String name;
    private String street;
    private String genre;
    private boolean doesDelivery;

}
