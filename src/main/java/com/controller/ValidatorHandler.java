package com.controller;

import com.entity.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/validator")
public class ValidatorHandler {

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("account",new Account());
        return "login2";
    }

    @PostMapping("/login")
    public String login(@Validated Account account, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "login2";
        }
        return "success";
    }
}
