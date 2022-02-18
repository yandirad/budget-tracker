package com.yandiradproject.budgettracker.services;

import com.yandiradproject.budgettracker.entities.Movement;
import com.yandiradproject.budgettracker.entities.User;
import com.yandiradproject.budgettracker.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author yandirad
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByName(userName);
        if (!user.getActive()) {
            return null;
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        // use list if you wish
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getGrants()));
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPass(),
                grantedAuthorities);
    }

    public User createUser(String name, Date createdAt, String pass)
            throws Exception {

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
            throws Exception {

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
