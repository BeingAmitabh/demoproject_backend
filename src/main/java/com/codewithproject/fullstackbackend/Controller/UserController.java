package com.codewithproject.fullstackbackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import com.codewithproject.fullstackbackend.Entity.User;
import com.codewithproject.fullstackbackend.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/save")
    public User userSave(@RequestBody User user) {
        User userall = service.saveData(user);
        return userall;
    }

    @GetMapping("/getAllData")
    public Page<User> getAllData(@RequestParam("pageno") int page,@RequestParam("pagesize") int pagesize) {
       Page<User> showData = service.showData(page,pagesize);
        return showData;
    }

    @GetMapping("/getById/{id}")
    public User getById(@PathVariable Long id) {
        User user = service.getById(id);
        return user;
    }
    @DeleteMapping("/deleteData/{id}")
    public List<User> deleteData(@PathVariable("id") long id){
                      List<User> deleteData = service.deleteData(id);
                      return deleteData;
    }
    @PutMapping("/update")
    public User updateData(@RequestBody User user){
                      User user2 = service.updateData(user);
                      return user2;
    }
}
