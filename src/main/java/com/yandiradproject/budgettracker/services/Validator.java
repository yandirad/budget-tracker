/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yandiradproject.budgettracker.services;

import com.yandiradproject.budgettracker.entities.Movement;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author yandirad
 */
@Service
public class Validator {

    public void stringValidate(String content, String name) throws Exception {
        if (content == null || content.isEmpty()) {
            throw new Exception(name + " can´t be null.");
        }
    }

    public void dateValidate(Date content, String name) throws Exception {
        if (content == null) {
            throw new Exception(name + " can´t be null.");
        }
    }

    public void doubleValidate(Double content, String name) throws Exception {
        if (content == null || content <= 0) {
            throw new Exception(name + " can´t be null.");
        }
    }
    
    public void integerValidate(Integer content, String name) throws Exception {
        if(content == null || content <= 0) {
                throw new Exception(name + " can´t be null.");
        }
    }
	
    public void MovementTypeValidate(Movement movement, String name) throws Exception {
        Integer code = movement.getType().getCode();
        if (movement == null) {
            throw new Exception(name + " can´t be null");
        } else if(code<0 || code>5){
            throw new Exception(movement + "it's not a valid type.");
        }
    }
}
