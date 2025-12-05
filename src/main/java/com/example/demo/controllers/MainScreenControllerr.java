package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

/**
 *
 *
 *
 *
 */

@Controller
public class MainScreenControllerr {



    private PartService partService;
    private ProductService productService;

    private List<Part> theParts;
    private List<Product> theProducts;

 /*   public MainScreenControllerr(PartRepository partRepository, ProductRepository productRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
    }*/

    public MainScreenControllerr(PartService partService,ProductService productService){
        this.partService=partService;
        this.productService=productService;
    }

    @GetMapping("/mainscreen")
    public String listPartsandProducts(Model theModel, @Param("partkeyword") String partkeyword, @Param("productkeyword") String productkeyword){
        //add to the sprig model
        List<Part> partList=partService.listAll(partkeyword);
        theModel.addAttribute("parts",partList);
        theModel.addAttribute("partkeyword",partkeyword);
    //    theModel.addAttribute("products",productService.findAll());
        List<Product> productList=productService.listAll(productkeyword);
        theModel.addAttribute("products", productList);
        theModel.addAttribute("productkeyword",productkeyword);
        return "mainscreen";
    }
    @GetMapping("/")
    public String redirectToMainScreen() {
        return "redirect:/mainscreen";
    }

    @GetMapping("/about")
    public String showAboutPage() {
        return "about";
    }
    @PostMapping("/products/{id}/buy")
    public String buyProduct(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {

        // Get the product
        Product product = productService.getById(id);   // make sure ProductService has this method

        if (product == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Purchase failed: product not found.");
            return "redirect:/mainscreen";
        }


        int currentInv = product.getInv();

        if (currentInv <= 0) {
            // failure message
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    "Purchase failed: '" + product.getName() + "' is out of stock."
            );
        } else {

            product.setInv(currentInv - 1);
            productService.save(product);

            // Success message
            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Successfully purchased '" + product.getName() + "'. Remaining inventory: " + product.getInv()
            );
        }

        // Go back to the main screen so messages and updated inventory show
        return "redirect:/mainscreen";
    }

}
