
package com.yandiradproject.budgettracker.services;

import com.yandiradproject.budgettracker.entities.Movement;
import com.yandiradproject.budgettracker.entities.User;
import com.yandiradproject.budgettracker.enumerations.MovementType;
import com.yandiradproject.budgettracker.repositories.MovementRepository;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author yandirad
 */
@Service
public class MovementService {
    
    @Autowired
    private MovementRepository movementRepository;
    
    public Movement createMovement(String name, Date createdAt, Integer type, Double amount, String userId) 
            throws Exception{
        Movement movement = new Movement();
        
        Validator validator = new Validator();
        validator.stringValidate(name, "Name");
        validator.dateValidate(createdAt, "Date");
        validator.doubleValidate(amount, "Amount");
        validator.movementTypeValidate(type, "Movement Type");
        
        MovementType mt = MovementType.values()[type];
        
        movement.setName(name);
        movement.setType(mt);
        movement.setAmount(amount);
        movement.setCreatedAt(createdAt);
        
        movementRepository.save(movement);
        
        return movement;
    }
    
    public Movement editMovement(String id, String name, Date createdAt, Integer type, Double amount) 
            throws Exception{
        
        Optional<Movement> movementOpt = movementRepository.findById(id);
        
        Validator validator = new Validator();
        validator.stringValidate(name, "Name");
        validator.dateValidate(createdAt, "Date");
        validator.doubleValidate(amount, "Amount");
        validator.movementTypeValidate(type, "Movement Type");
        
        MovementType mt = MovementType.values()[type];
        Movement movement = movementOpt.get();
        
        movement.setName(name);
        movement.setCreatedAt(createdAt);
        movement.setType(mt);
        movement.setAmount(amount);
        
        movementRepository.save(movement);
        return movement;
        
    }

}
