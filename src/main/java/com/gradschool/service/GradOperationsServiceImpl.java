package com.gradschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gradschool.model.GradOperations;
import com.gradschool.repository.GradOperationsRepository;

@Service
public class GradOperationsServiceImpl {

	@Autowired
	private GradOperationsRepository gradOperationsRepository;
	
	
	public void announceDateAndLocations() {
		
		GradOperations op = gradOperationsRepository.getOne((long) 1);
		op.setDateAndLocationAnnouncement(true);
		gradOperationsRepository.save(op);
	}
	
	public void deliver() {
		GradOperations op = gradOperationsRepository.getOne((long)1);
		op.setDeliverApps(true);
		gradOperationsRepository.save(op);
	}
	
	public void deliverInterviews() {
		GradOperations op = gradOperationsRepository.getOne((long)1);
		op.setDeliverInterviews(true);
		gradOperationsRepository.save(op);
	}
	public void deliverNotes() {
		GradOperations op = gradOperationsRepository.getOne((long)1);
		op.setDeliverNotes(true);
		gradOperationsRepository.save(op);
	}
	
	public void announceResults() {
		GradOperations op = gradOperationsRepository.getOne((long) 1);
		op.setResultAnnouncement(true);
		gradOperationsRepository.save(op);
	}
	
	public void finishComfirmation() {
		GradOperations op = gradOperationsRepository.getOne((long) 1);
		op.setFinishComfirmation(true);
		gradOperationsRepository.save(op);
	}
	public void finishVerification() {
		GradOperations op = gradOperationsRepository.getOne((long) 1);
		op.setFinishVerification(true);
		gradOperationsRepository.save(op);
	}
	
	public GradOperations getOperations() {
		return gradOperationsRepository.getOne((long) 1) ;
	}

	public void startApplications() {
		GradOperations op = gradOperationsRepository.getOne((long) 1);
		op.setAppsStartStop(true);
		gradOperationsRepository.save(op);
	}
	
	public void stopApplications() {
		GradOperations op = gradOperationsRepository.getOne((long) 1);
		op.setAppsStartStop(false);
		gradOperationsRepository.save(op);
	}
	
	
	
	
}
