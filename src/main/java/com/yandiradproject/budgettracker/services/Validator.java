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
	
    public void movementTypeValidate(Integer movementType, String name) throws Exception {
        if (movementType == null || movementType < 0) {
            throw new Exception(name + " can´t be negative or an empty value.");
        } else if(movementType>5){
            throw new Exception(movementType + " it's not a valid type.");
        }
    }
    
    public void passValidate(String pass, String name) throws Exception {
        if(pass == null || pass.isEmpty() || pass == "" || pass.length() < 8){
            throw new Exception(name + " can´t be an empty value and must have at least 8 characters.");
        }
    }
}
