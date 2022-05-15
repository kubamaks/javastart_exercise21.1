package pl.km.exercise211;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Collection<Product> findByCategory(Category category) {
        if (category == null) {
            return productRepository.findAll();
        } else {
            return productRepository.findAll().stream()
                    .filter(p -> p.getCategory().equals(category))
                    .toList();
        }
    }

    public double getTotalPrice(Collection<Product> products) {
        return products.stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);
    }

    public void addProduct(Product product) {
        productRepository.add(product);
    }
}
