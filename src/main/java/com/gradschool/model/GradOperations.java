package com.gradschool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gradOperations")
public class GradOperations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private boolean dateAndLocationAnnouncement ;
	
	private boolean deliverApps;
	
	private boolean deliverInterviews;
	
	private boolean deliverNotes;
	
	private boolean appsStartStop;
	
	private boolean resultAnnouncement;
	
	private boolean finishComfirmation;
	
	private boolean finishVerification;
	


	public boolean isDateAndLocationAnnouncement() {
		return dateAndLocationAnnouncement;
	}

	public void setDateAndLocationAnnouncement(boolean dateAndLocationAnnouncement) {
		this.dateAndLocationAnnouncement = dateAndLocationAnnouncement;
	}

	public boolean isDeliverApps() {
		return deliverApps;
	}

	public void setDeliverApps(boolean deliverApps) {
		this.deliverApps = deliverApps;
	}

	public boolean isResultAnnouncement() {
		return resultAnnouncement;
	}

	public void setResultAnnouncement(boolean resultAnnouncement) {
		this.resultAnnouncement = resultAnnouncement;
	}

	public boolean isFinishComfirmation() {
		return finishComfirmation;
	}

	public void setFinishComfirmation(boolean finishComfirmation) {
		this.finishComfirmation = finishComfirmation;
	}

	public boolean isFinishVerification() {
		return finishVerification;
	}

	public void setFinishVerification(boolean finishVerification) {
		this.finishVerification = finishVerification;
	}

	public boolean isDeliverInterviews() {
		return deliverInterviews;
	}

	public void setDeliverInterviews(boolean deliverInterviews) {
		this.deliverInterviews = deliverInterviews;
	}

	public boolean isDeliverNotes() {
		return deliverNotes;
	}

	public void setDeliverNotes(boolean deliverNotes) {
		this.deliverNotes = deliverNotes;
	}

	public boolean isAppsStartStop() {
		return appsStartStop;
	}

	public void setAppsStartStop(boolean appsStartStop) {
		this.appsStartStop = appsStartStop;
	}
	
	
}
