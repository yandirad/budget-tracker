package com.yandiradproject.budgettracker.services;

import com.yandiradproject.budgettracker.entities.Movement;
import com.yandiradproject.budgettracker.entities.User;
import com.yandiradproject.budgettracker.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author yandirad
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
        public User createUser(String name, Date createdAt, String pass) 
            throws Exception{
            
            User user = new User();

            Validator validator = new Validator();
            validator.stringValidate(name, "Name");
            validator.dateValidate(createdAt, "Date");

            List<Movement> movementsList = new ArrayList();

            user.setName(name);
            user.setCreatedAt(createdAt);
            user.setPass(pass);
            user.setMovements(movementsList);
            return user;
    }
    
    public User editUser(String id, String name, List<Movement> movements, Date createdAt, String pass) 
            throws Exception{
        
        Optional<User> userOpt = userRepository.findById(id);
        
        Validator validator = new Validator();
        validator.stringValidate(name, "Name");
        validator.dateValidate(createdAt, "Date");
        validator.passValidate(pass, "Pass");
        
        User user = userOpt.get();
        
        user.setName(name);
        user.setMovements(movements);
        user.setCreatedAt(createdAt);
        user.setPass(pass);
        
        return user;  
    }


}
