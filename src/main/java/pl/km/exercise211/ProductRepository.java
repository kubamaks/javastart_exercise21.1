package pl.km.exercise211;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Repository
class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("Orzechy włoskie - 250g", BigDecimal.valueOf(3.55), Category.GLOCERIES));
        products.add(new Product("Mleko UHT 3.5%", BigDecimal.valueOf(4.50), Category.GLOCERIES));
        products.add(new Product("Nóż szefa kuchni 25cm", BigDecimal.valueOf(85.10), Category.HOUSEHOLD));
        products.add(new Product("Mop \"śmigacz\"", BigDecimal.valueOf(25.90), Category.HOUSEHOLD));
        products.add(new Product("Kurtka \"niewidka\"", BigDecimal.valueOf(98.89), Category.OTHER));
        products.add(new Product("Skarpetki ortopedyczne rozmiar 52", BigDecimal.valueOf(11.25), Category.OTHER));
    }

    public void add(Product product) {
        products.add(product);
    }

    public Collection<Product> findAll() {
        return products;
    }
}
