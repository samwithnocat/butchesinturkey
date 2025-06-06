package com.birthdayapp.birthdayportal;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public String showLoginPage() {
        return "FirstPage"; // loads templates/login.html
    }

    @PostMapping("/")
    public String login(@RequestParam String name,
                        @RequestParam String password,
                        HttpSession session) {

        System.out.println("Login attempt: name=" + name + ", password=" + password);
        Optional<User>user = userRepository.findByNameAndPassword(name, password);
        if ("jasmin".equalsIgnoreCase(name) && password.equals("secret")) {
            session.setAttribute("user", name);
            return "redirect:/view-wishes";
        }

        if (password.equals("wish123")) {
            session.setAttribute("user", name);
            return "redirect:/write-wish";
        }

        return "login-failed";
    }
//    @GetMapping("/view-wishes")
//    public String showViewWishes () {
//        return "view-wishes";
//    }

    @GetMapping("/write-wish")
    public String showWriteWishes () {
        return "write-wish";
    }





//public String login(@RequestParam String name,
//                    @RequestParam String password,
//                    HttpSession session) {
//
//    // Hardcoded shared password
//    final String sharedPassword = "wish123";
//    final String jasminPassword = "jjs";
//
//    if ("jasmin".equalsIgnoreCase(name) && password.equals(jasminPassword)) {
//        session.setAttribute("user", name);
//        return "redirect:/view-wishes"; // Only jasmin can see wishes
//    }
//
//    if (password.equals(sharedPassword)) {
//        session.setAttribute("user", name);
//        return "redirect:/write-wish";  // Anyone else can write a wish
//    }
//
//    return "login-failed";
//}

}
