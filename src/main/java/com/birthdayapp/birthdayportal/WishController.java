package com.birthdayapp.birthdayportal;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class WishController {
    @Autowired
    private WishRepository repository;
    private User user;


//        @PostMapping("/submit-wish")
//        public String submitWish(@RequestParam String message, HttpSession session) {
//            System.out.println("message submitted");
//            User user = (User) session.getAttribute("user");
//            if (user == null) {
//                return "redirect:/FirstPage";
//            }
//
//            Wish wish = new Wish(message);
//            repository.save(wish);
//
//            return "thank-you"; // Load thank-you.html
//        }
//    @GetMapping("/write-wish")
//    public String showWishForm() {
//        return "write-wish";  // this should match your template file write-wish.html
//    }
//


    @PostMapping("/submit-wish")
    public String submitWish(@RequestParam String message, HttpSession session) {
        System.out.println("Received wish: " + message);
        String name = (String) session.getAttribute("user");
        Wish wish = new Wish();
        wish.setMessage(message);
       wish.setSender(name);
        repository.save(wish);
        return "thank-you";   // this should match thank-you.html template
    }
    @GetMapping("/view-wishes")
    public String viewWishes(Model model) {
        List<Wish> wishes = repository.findAll();
        System.out.println(wishes.size());
        model.addAttribute("wishes", wishes);
        return "view-wishes";  // corresponds to view-wishes.html
    }




    public List<Wish> getAllWishes() {
            return repository.findAll();
        }

    }

    //    public Wish addWish (@RequestBody Wish wish) {
//        if(wish==null) {
//            return null;
//        }
//        return repository.save(wish);
//    }
//@PostMapping("/submit-wish")
//public String submitWish(@RequestParam String message, HttpSession session) {
//    User user = (User) session.getAttribute("user");
//
//    Wish wish = new Wish(message);
//    repository.save(wish);
//
//    return "thank-you"; // Redirect back after submission
//}
