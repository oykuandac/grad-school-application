package com.gradschool.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "application")
public class Application {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date;
	
	private boolean isConfirmed;
	
	private boolean isVerifed;
	
	@OneToOne
	@JsonManagedReference
	private PreApplication preApplication;
	


	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonManagedReference
	private User user;
	
	private boolean isAccepted;
	
	@OneToMany
    @JoinColumn(name = "file_id", referencedColumnName = "id")
    @JsonBackReference
	private List<File> files;
	
    @OneToOne
    @JoinColumn(name = "interview_id")
	private Interview interview;

	public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview interview) {
		this.interview = interview;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isConfirmed() {
		return isConfirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public PreApplication getPreApplication() {
		return preApplication;
	}

	public void setPreApplication(PreApplication preApplication) {
		this.preApplication = preApplication;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public boolean isVerifed() {
		return isVerifed;
	}

	public void setVerifed(boolean isVerifed) {
		this.isVerifed = isVerifed;
	}
	
}
