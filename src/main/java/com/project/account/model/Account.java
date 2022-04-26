package com.project.account.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accId;
	private String name;
	private float accBalance;
	private String email;
	private String message;

}
