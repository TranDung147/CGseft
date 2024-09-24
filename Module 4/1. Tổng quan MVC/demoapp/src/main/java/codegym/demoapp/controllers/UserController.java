package codegym.demoapp.controllers;

import codegym.demoapp.entities.User;
import codegym.demoapp.request.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
        import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")

public class UserController {
    public List<User> listUser;

    public UserController() {
        listUser = new ArrayList<>();
        listUser.add(new User(1, "Nam"));
        listUser.add(new User(2, "Nhan"));
        listUser.add(new User(3, "Tam"));
    }

    @GetMapping("")
    public String listUser(Model model) {
        model.addAttribute("users", listUser);
        return "users/list";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        listUser.removeIf(user -> user.getId() == id);
        return "redirect:/users";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        return "users/add";
    }

    @PostMapping("/add")
    public String saveUser(@ModelAttribute("userRequest") UserRequest userRequest, BindingResult result) {
        // Xu ly upload file
        MultipartFile avatar = userRequest.getAvatar();
        if (avatar != null && !avatar.isEmpty()) {
            String fileName = avatar.getOriginalFilename();
            assert fileName != null;
            File file = new File(fileName);
            try {
                avatar.transferTo(file);
            } catch (IOException e) {
                System.out.println("Error uploading");
            }

        }
        System.out.println(userRequest.getName());
        return "redirect:/users";

    }
}
