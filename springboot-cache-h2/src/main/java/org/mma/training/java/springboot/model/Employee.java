package org.mma.training.java.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="EMP")
public class Employee {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String position;
	private String email;
	private String department;
	private String manager;
	private String phone;
	private Long salary;

}
