package com.ultragroup.agenciaviaje.model.user;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1910287765619171321L;

    @Id
    @NotNull
    private String userId; 

    @NotNull
    private String name;
    
    @NotNull
    private String login;
    
    @NotNull
    private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}
