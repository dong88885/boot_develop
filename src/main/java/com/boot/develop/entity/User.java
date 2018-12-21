package com.boot.develop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity(name="User")
@ApiModel("User model entity")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty("user id primary key")
	@Id
	@GeneratedValue
	int id;
	
	@ApiModelProperty(value="username",required=true)
	@Column(length=255)
	@Length(min=8,max=32)
	String userName;
	
	@ApiModelProperty(value="password for user",required=true)
	@NotNull
	@Column(length=64)
	String passWord;
	
	@ApiModelProperty(value=" user people age",required=false)
	int age;
	
	
	

}
