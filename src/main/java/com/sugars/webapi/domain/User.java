package com.sugars.webapi.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	
    @Id
    //@GeneratedValue
    private Long userid;
    private String name;
    private String email;
}
