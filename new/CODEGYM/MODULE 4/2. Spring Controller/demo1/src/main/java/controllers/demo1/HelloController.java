package controllers.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// @ annotation
@Controller // đánh dấu 1 class ta ra bean có nhệm vụ làm controller
// bean được đưa vào IOC container quản lý
@RequestMapping("/") // url handle mapping
public class HelloController {
    @GetMapping//hanlde method
    public String showMsg(Model model){
        String msg = "Xin chao trang web";
        model.addAttribute("message", msg); // gửi dữ liệu tới view
        return "home";
    }
    @GetMapping("rp")
    public void showRp(@RequestParam(name = "id", defaultValue = "0", required = false) int id,
                       @RequestParam("email") String email) {
        System.out.println(id + " - " + email);
    }
    @GetMapping("pv/{id:^\\d$}/{name}")
    public void showPv(@PathVariable("id") int id, @PathVariable("name") String name){
        System.out.println(id + " - " + name);
    }
}
