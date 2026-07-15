package com.SkillSwap.Skill_Swap_project.Controller;

import com.SkillSwap.Skill_Swap_project.Entity.User;
import com.SkillSwap.Skill_Swap_project.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

   private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
    }
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/email/{email}")
    public Optional<User> getUserByEmail( @PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable long id){
        userService.deleteUser(id);
    }








}
