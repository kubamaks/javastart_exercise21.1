package pl.km.exercise211;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Collection;

@Controller
class HomeController {
    private final ProductService productService;
    private final String updateDate = "May 15th'22";

    HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("spozywcze", Category.GLOCERIES);
        model.addAttribute("domowe", Category.HOUSEHOLD);
        model.addAttribute("inne", Category.OTHER);
        return "index";
    }

    @GetMapping("/produkty")
    public String listProducts(@RequestParam(name = "kategoria", required = false) String categoryTag,
                        Model model) {
        Category category = Category.fromTag(categoryTag);
        Collection<Product> products = productService.findByCategory(category);
        BigDecimal priceSum = productService.getTotalPrice(products);
        model.addAttribute("products", products);
        model.addAttribute("priceSum", priceSum);
        model.addAttribute("category", category);

        return "produkty";
    }

    @GetMapping("/dodaj")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "formularz";
    }

    @PostMapping("/zapisz")
    public String saveProduct(Product product) {
        productService.addProduct(product);
        return "redirect:/";

    }
}
