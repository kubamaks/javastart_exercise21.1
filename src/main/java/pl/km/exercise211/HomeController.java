package pl.km.exercise211;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {
    private  ProductService productService;

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
}
