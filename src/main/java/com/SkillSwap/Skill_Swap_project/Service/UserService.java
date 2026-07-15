package com.SkillSwap.Skill_Swap_project.Service;

import com.SkillSwap.Skill_Swap_project.Entity.User;
import com.SkillSwap.Skill_Swap_project.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

     private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
    public  Optional<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public User addUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> login(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
        return Optional.empty();
    }
     public void deleteUser(Long id){
        userRepository.deleteById(id);
     }
     public User updateUser(Long id,User user){
         User existingUser = userRepository.findById(id)
                 .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

         existingUser.setName(user.getName());
         existingUser.setEmail(user.getEmail());
         existingUser.setPassword(user.getPassword());
         existingUser.setBio(user.getBio());
         existingUser.setLocation(user.getLocation());
         return userRepository.save(existingUser);
     }





}
