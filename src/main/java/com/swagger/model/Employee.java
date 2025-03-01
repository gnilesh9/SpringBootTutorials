package com.swagger.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "employees")
@Schema(description = "Employee entity representing a company worker")
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the employee", example = "1")
    private Long id;

    @Schema(description = "Employee's full name", example = "Nilesh Gadekar")
    private String name;

    @Schema(description = "Employee's email address", example = "gnilesh@gmail.com")
    private String email;
    
    public Employee() {}

    public Employee(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

}
