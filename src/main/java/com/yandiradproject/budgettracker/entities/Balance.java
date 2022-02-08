/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class Balance implements Serializable {
    
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
    private List<Movement> movements;
    
    @Column
    private Double total;

}
