package cat.itb.m3uf6projecte_juradomirodavid.model.repository;

import cat.itb.m3uf6projecte_juradomirodavid.model.pojo.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryRestaurants extends CrudRepository<Restaurant, String> {

    Restaurant findByName(String name);

}
