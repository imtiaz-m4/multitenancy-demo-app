package com.metafour.multitenancy.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Employee JPA entity, enhanced using lombok.
 * 
 * @author Imtiaz Rahi
 * @since 2017-08-25
 * @see EmployeeRepository
 */
@Entity
@Data @NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@NotNull @NonNull
	String firstName, lastName;

	String department, office;
}
