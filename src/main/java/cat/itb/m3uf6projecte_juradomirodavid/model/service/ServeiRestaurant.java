package cat.itb.m3uf6projecte_juradomirodavid.model.service;

import cat.itb.m3uf6projecte_juradomirodavid.model.pojo.Restaurant;
import cat.itb.m3uf6projecte_juradomirodavid.model.repository.RepositoryRestaurants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class ServeiRestaurant {

    @Autowired
    private RepositoryRestaurants repo;

    public void afegirRestaurant(Restaurant data) {
        Restaurant restaurant = new Restaurant(data.getName(), data.getStreet(), data.getGenre(), data.isDoesDelivery());

        repo.save(restaurant);
        System.out.println("Restaurant afegit: [" + restaurant + "] satisfactoriament.");
    }

    public List<Restaurant> getAll() {
        return (List<Restaurant>) repo.findAll();
    }

    public Restaurant getByName(String name) {
        Restaurant queried = new Restaurant();
        List<Restaurant> list = getAll();
        for (Restaurant r : list) {
            if (r.getName().equals(name)) {
                queried = r;
                break;
            }
        }
        return queried;
    }

    public void updateRestaurant(Restaurant r) {
        deleteRestaurant(r.getName());
        afegirRestaurant(r);
    }

    public void deleteRestaurant(String name) {
        Restaurant r = getByName(name);
        repo.delete(r);
    }

    @PostConstruct
    public void init() {
        repo.save(new Restaurant("Ryu Ramen", "C/Sancho de Ávila, 178, 08018", "Oriental", true));
        repo.save(new Restaurant("El Pibe", "C/Artesania, 54, 08042", "Americà", true));
        repo.save(new Restaurant("Sapri pizza", "Passeig Maragall, 308, 08031", "Italià", true));
        repo.save(new Restaurant("Restaurante Montevideo", "Avinguda de la Constitució, 30, 08860", "Sudamericà", true));
    }
}
