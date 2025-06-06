package com.birthdayapp.birthdayportal;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private WishRepository wishRepository;

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/login"; // If user is not logged in
        }

        if ("BIRTHDAY".equalsIgnoreCase(user.getRole())) {
            model.addAttribute("wishes", wishRepository.findAll());
            return "view-wishes"; // Show birthday girl's dashboard
        } else {
            return "write-wish"; // Show wish form for friends
        }
    }
}
