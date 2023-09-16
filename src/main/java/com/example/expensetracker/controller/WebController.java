package com.example.expensetracker.controller;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.model.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
public class WebController {
    private final ExpenseRepository expenseRepository;

    @Autowired
    public WebController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @RequestMapping("/")
    public String home(Model model) {
        List<Expense> expenses = expenseRepository.findAll();
        model.addAttribute("expenses", expenses);
        return "expenses";
    }
}
