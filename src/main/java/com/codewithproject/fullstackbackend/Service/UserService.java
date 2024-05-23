package com.codewithproject.fullstackbackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.codewithproject.fullstackbackend.Entity.User;
import com.codewithproject.fullstackbackend.Repository.UserReopsitory;

@Service
public class UserService {
    @Autowired
    private UserReopsitory repo;

    public User saveData(User user) {
        User save = repo.save(user);
        return save;
    }

    public Page<User> showData(int pageno,int pagesize) {
        PageRequest page = PageRequest.of(pageno, pagesize);
        Page<User> all = repo.findAll(page);
        return all;
    }

    public User getById(Long id) {
        Optional<User> userData = repo.findById(id);
        return userData.orElse(null);
    }

    public List<User> deleteData(Long Id) {
        repo.deleteById(Id);
        return repo.findAll();
    }

    public User updateData(User user) {
       return repo.save(user);
    }

}
