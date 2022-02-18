/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yandiradproject.budgettracker.repositories;

import com.yandiradproject.budgettracker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yandirad
 */
@Repository
public interface UserRepository extends JpaRepository<User, String>{
    
    public User findByName(String name);
}
