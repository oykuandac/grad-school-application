package com.gradschool.model;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;


import java.sql.Time;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Interview")
public class Interview {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date date;

	private String location;
    
    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    */
    
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnore
	private User department;  // departmannnnnnnn  ----id de olabilir??????

  
    
	private double note;
    
       
    @OneToOne
    @JsonIgnore
    private Application application;



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public double getNote() {
		return note;
	}



	public void setNote(double note) {
		this.note = note;
	}





	public Long getId() {
		return id;
	}


    
    public User getDepartment() {
		return department;
	}



	public void setDepartment(User department) {
		this.department = department;
	}



	public Application getApplication() {
		return application;
	}



	public void setApplication(Application application) {
		this.application = application;
	}



	public void setId(Long id) {
		this.id = id;
	}





    
    
    
}
