package com.example.demo.controllers;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AddOutsourcedPartController {

    @Autowired
    private PartService partService;

    @GetMapping("/showFormAddOutPart")
    public String showFormAddOutPart(Model model) {
        model.addAttribute("outsourcedpart", new OutsourcedPart());
        return "OutsourcedPartForm";
    }

    @PostMapping("/showFormAddOutPart")
    public String saveOutsourcedPart(
            @Valid @ModelAttribute("outsourcedpart") OutsourcedPart part,
            BindingResult bindingResult,
            Model model) {

        // -----------------------------
        // 🔹 VALIDATION RULES
        // -----------------------------

        // Min cannot be > max
        if (part.getMinInv() > part.getMaxInv()) {
            bindingResult.reject("minMaxError",
                    "Minimum inventory cannot be greater than maximum inventory.");
        }

        // Inventory < min
        if (part.getInv() < part.getMinInv()) {
            bindingResult.rejectValue("inv", "invTooLow",
                    "Inventory cannot be less than the minimum.");
        }

        // Inventory > max
        if (part.getInv() > part.getMaxInv()) {
            bindingResult.rejectValue("inv", "invTooHigh",
                    "Inventory cannot be greater than the maximum.");
        }

        // If any errors, return to form
        if (bindingResult.hasErrors()) {
            return "OutsourcedPartForm";
        }

        // Save if valid
        partService.save(part);

        return "redirect:/mainscreen";
    }
}
