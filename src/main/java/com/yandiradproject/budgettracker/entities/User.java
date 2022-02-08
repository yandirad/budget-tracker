package com.yandiradproject.budgettracker.entities;

import com.yandiradproject.budgettracker.enumerations.MovementType;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import org.hibernate.annotations.GenericGenerator;


/**
 *
 * @author yandirad
 */
@Entity
public class User implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdAt;
    
    @OneToMany
    @Column
    private Balance balance;
    

}
