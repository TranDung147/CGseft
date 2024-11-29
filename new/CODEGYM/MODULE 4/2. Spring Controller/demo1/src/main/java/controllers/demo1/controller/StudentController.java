package controllers.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class StudentController {
    @GetMapping
    public String showStudentList() {
        return "home";
    }
    @GetMapping("/show-create-form")
    public String showCreateForm() {
        return "create-form";
    }
}
