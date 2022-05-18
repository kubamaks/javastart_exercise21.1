package pl.km.exercise211;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public Collection<Product> findAll() {
        return productRepository.findAll();
    }

    public BigDecimal getTotalPrice(Collection<Product> products) {
        return products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addProduct(Product product) {
        productRepository.add(product);
    }
}
