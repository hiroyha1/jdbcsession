package com.samples.jdbcsession.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        String message = (String)session.getAttribute("MESSAGE");

        model.addAttribute("message", message != null ? message : "<empty>");
        return "index";
    }

    @PostMapping("/add")
    public String add(@RequestParam("message") String message, HttpServletRequest request)
    {
        request.getSession().setAttribute("MESSAGE", message);
        return "redirect:/";
    }
}
