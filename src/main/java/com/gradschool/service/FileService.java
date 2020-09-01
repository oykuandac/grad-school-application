package com.gradschool.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.gradschool.model.File;

public interface FileService {
	
	 public File storeFile(MultipartFile file);

	 public File getFile(String fileId);
	 
	 public List<File> getAllFiles(); 
	 
	 public List<File> getFilesByApplicationId(long appId);
	 
	 public void delete(String fileId);
	 
	 public File storeFileForApp(long appId,MultipartFile file);
 
}
