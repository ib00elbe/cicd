package com.cicd.calculator;

import com.cicd.calculator.domain.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CalculatorController {

	@GetMapping("/add")
	public String addForm(Model model) {
	  model.addAttribute("calculator", new Calculator());
	  return "add";
	}
  
	@PostMapping("/add")
	public String addSubmit(@Valid @ModelAttribute Calculator calculator, BindingResult res, Model model) {
		if(res.hasErrors()){
			return "add";
		}
		int result = calculator.Add(calculator.getFirstValue(), calculator.getSecondValue());
	  	model.addAttribute("result", result);
	  	return "result";
	}

	@GetMapping("/subtract")
	public String subtractForm(Model model) {
		model.addAttribute("calculator", new Calculator());
		return "subtract";
	}

	@PostMapping("/subtract")
	public String subtractSubmit(@ModelAttribute Calculator calculator, BindingResult res, Model model) {
		if(res.hasErrors()){
			return "subtract";
		}
		int result = calculator.Subtract(calculator.getFirstValue(), calculator.getSecondValue());
		model.addAttribute("result", result);
		return "result";
	}
	@GetMapping("/multiply")
	public String multiplyForm(Model model) {
		model.addAttribute("calculator", new Calculator());
		return "multiply";
	}

	@PostMapping("/multiply")
	public String multiplySubmit(@ModelAttribute Calculator calculator, BindingResult res, Model model) {
		if(res.hasErrors()){
			return "multiply";
		}
		int result = calculator.Multiply(calculator.getFirstValue(), calculator.getSecondValue());
		model.addAttribute("result", result);
		return "result";
	}

	@GetMapping("/divide")
	public String divideForm(Model model) {
		model.addAttribute("calculator", new Calculator());
		return "divide";
	}

	@PostMapping("/divide")
	public String divideSubmit(@ModelAttribute Calculator calculator, BindingResult res, Model model) {
		if(res.hasErrors()){
			return "divide";
		}
		double result = calculator.Divide(calculator.getFirstValue(), calculator.getSecondValue());
		model.addAttribute("result", result);
		return "result";
	}
}
