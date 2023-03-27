package com.example.movies.user;

import com.example.movies.authorization.LogInHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public  void addNewUser(User user) throws IllegalAccessException {
      Optional<User>  userByUsername = userRepository.findUserByUsername(user.getUsername());
        if(userByUsername.isPresent()) {
            throw new IllegalAccessException("Username already exists");
        }
        userRepository.save(user);

    }

    public boolean authenticate(User user) {
       Optional<User> findUser = userRepository.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
       if(findUser.isEmpty()){
            return false;
        }
       LogInHelper.getInstance().setAdmin(true);
        return true;
    }
    public boolean isUsernameEmpty(User user){
        if(user.getUsername().isBlank()){
            return true;
        }
        return  false;
    }
    public boolean isPasswordEmpty(User user){
        if(user.getPassword().isBlank()){
            return true;
        }
        return  false;
    }


    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userRepository.findAll());

    }
}
