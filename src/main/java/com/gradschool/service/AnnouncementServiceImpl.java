package com.gradschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gradschool.model.Announcement;
import com.gradschool.repository.AnnouncementRepository;

@Service
public class AnnouncementServiceImpl {

	
	@Autowired
	private AnnouncementRepository announcementRepository;
	
	
	public void save(Announcement announcement) {
		announcementRepository.save(announcement);
	}
	
	public List<Announcement> getAll(){
		return announcementRepository.findAll();
	}
	
	
	
}
