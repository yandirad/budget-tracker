/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yandiradproject.budgettracker.entities;

import com.yandiradproject.budgettracker.enumerations.MovementType;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author yandirad
 */
@Entity
public class Movement implements Serializable {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdAt;
    @Column
    private MovementType type;
    @Column
    private Double amount;

    public Movement() {
    }
    
    public Movement(String id, String name, Date createdAt, MovementType type, Double amount) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.type = type;
        this.amount = amount;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public MovementType getType() {
        return type;
    }

    public void setType(MovementType type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    
}
