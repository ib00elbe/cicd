package com.cicd.calculator;

import com.cicd.calculator.domain.Inspiration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InspirationController {
    @GetMapping("/quote")
    public String quoteForm(Model model) {
        Inspiration inspiration = new Inspiration();
        String quote = inspiration.Quote();
        model.addAttribute("quote", quote);
        return "quote";
    }
}
