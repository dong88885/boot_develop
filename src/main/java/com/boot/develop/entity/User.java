package com.boot.develop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
@Entity(name="User")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	int id;
	
	@Column(length=255)
	@Length(min=8,max=32)
	String userName;
	
	@NotNull
	@Column(length=64)
	String passWord;
	
	int age;
	
	
	static interface UserA {
		
		String getUserName();
		
	}
	
	
   public static class  UserAImpl implements UserA {
		
		String userName2;
		
		public String getUserName() {
			
			
			return userName2;
			
		}
	}
	
	public static void main2(String[] args) {
		
		UserA  user=new UserAImpl();
		
		user.getUserName();
	}
	

}
