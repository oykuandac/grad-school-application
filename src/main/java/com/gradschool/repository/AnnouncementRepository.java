package com.gradschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradschool.model.Announcement;
import com.gradschool.model.Application;

public interface AnnouncementRepository  extends JpaRepository<Announcement, Long>{ 

}
