package com.gradschool.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String surname;
    
    private String email;

    private String password;
    
    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private Set<Application> appList;
    
    
    @OneToMany(mappedBy = "department")
    private Set<Interview> interviewList;
    

    @ManyToOne
    private Role roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Set<Application> getAppList() {
		return appList;
	}

	public void setAppList(Set<Application> appList) {
		this.appList = appList;
	}
	public Set<Interview> getInterviewList() {
		return interviewList;
	}

	public void setInterviewList(Set<Interview> interviewList) {
		this.interviewList = interviewList;
	}

	

}
