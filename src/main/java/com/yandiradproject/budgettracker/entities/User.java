package com.yandiradproject.budgettracker.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
    private String pass;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdAt;
    
    @OneToMany
    @Column
    private List<Movement> movements;

    public User() {
    }

    public User(String id, String name, String pass, Date createdAt, List<Movement> movements) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.createdAt = createdAt;
        this.movements = movements;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }

}
