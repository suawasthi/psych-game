package com.psych.game.models;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;


@Data
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public  abstract class Employee extends User {

	private String name;
	private String Address;
	private Long phoneNo = 0L;
}
