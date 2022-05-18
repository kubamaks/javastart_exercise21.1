package pl.km.exercise211;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Collection;

@Controller
class ProductController {

    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/produkty")
    public String listProducts(@RequestParam(name = "kategoria", required = false) String categoryTag,
                               Model model) {
        Category category = null;
        Collection<Product> products = null;
        if (categoryTag != null) {
            try {
                category = Category.fromTag(categoryTag);
                products = productService.findByCategory(category);
            } catch (NullPointerException e) {
                String categoryErrorMassage = e.getMessage();
            }
        } else {
            products = productService.findAll();
        }
        BigDecimal priceSum = productService.getTotalPrice(products);
        model.addAttribute("products", products);
        model.addAttribute("priceSum", priceSum);
        model.addAttribute("category", category);

        return "products";
    }

    @GetMapping("/dodaj")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "form";
    }

    @PostMapping("/zapisz")
    public String saveProduct(Product product) {
        productService.addProduct(product);
        return "redirect:/";
    }
}
