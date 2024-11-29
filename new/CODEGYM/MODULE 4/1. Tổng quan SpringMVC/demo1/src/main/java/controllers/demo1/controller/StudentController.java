package controllers.demo1.controller;

import controllers.demo1.model.Student;
import controllers.demo1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping
    public String showStudentList(Model model) {
        model.addAttribute("student", studentService.findAll());
        return "home";
    }
    @GetMapping("/show-create-form")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        return "create-form";
    }
    @PostMapping("save-student")
    public String saveStudent(@ModelAttribute("student") Student student, RedirectAttributes redirectAttributes) {
        studentService.saveStudent(student);
        redirectAttributes.addFlashAttribute("msg", "them moi thanh cong");
        return "redirect:/";
    }
}
