package com.birthdayapp.birthdayportal;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "app_user")  // Avoid conflict with SQL reserved word "user"
public class User {

    @Id
    private String name; // Primary key

    private String password;
    private String role; // "FRIEND" or "BIRTHDAY"

    public User() {}

    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "app_user")
//public class User {
//
//        @Id
//        private String name; // keep it simple, use name as ID
//        private String password;
//        private String role; // "FRIEND" or "BIRTHDAY"
//
//    public User() {
//
//    }
//
//    public User(String name, String password, String role) {
//        this.name = name;
//        this.password = password;
//        this.role = role;
//    }
//
//}
//
