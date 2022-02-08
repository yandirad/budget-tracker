
package com.yandiradproject.budgettracker.repositories;

import com.yandiradproject.budgettracker.entities.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yandirad
 */
@Repository
public interface MovementRepository extends JpaRepository<Movement, String>{
    
}
