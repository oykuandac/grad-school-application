package com.gradschool.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.gradschool.exceptions.FileStorageException;
import com.gradschool.exceptions.MyFileNotFoundException;
import com.gradschool.model.Application;
import com.gradschool.model.File;
import com.gradschool.model.User;
import com.gradschool.repository.ApplicationRepository;
import com.gradschool.repository.FileRepository;
import com.gradschool.repository.UserRepository;


@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
    private FileRepository fileRepository;
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SecurityServiceImpl securityServiceImpl;
	
	
    public File storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            
            String s =securityServiceImpl.findLoggedInUsername();
    		User user = userRepository.findByEmail(s);
    		List<Application> applications = applicationRepository.findByUser(user);
    		applications.sort(Comparator.comparing(Application::getDate).reversed());

    		
            File dbFile = new File(fileName, file.getContentType(), file.getBytes());

            for(Application app: applications ) {
    			if(app.getUser().equals(user)) {
    				dbFile.setApplication(app);
    				break;
    			}
    		}
            return fileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public List<File> getFilesByApplicationId(long appId) {
    	List<File> files = fileRepository.findAll();
    	List<File> appFiles = new ArrayList<File>();
    	
    	for (File file:files) {
    		if(file.getApplication().getId()==appId)
    			appFiles.add(file);
    	}
    	return appFiles;
    }
     
    
    public File getFile(String fileId) {
        return fileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
    
    public List<File> getAllFiles() {
    	return fileRepository.findAll();
    }
    
    
    
    public void delete(String fileId) {
    	fileRepository.deleteById(fileId);
    }

	@Override
	public File storeFileForApp(long appId, MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            
            Application appl = applicationRepository.findById(appId)
            						.orElse(null);
            
    		User user = appl.getUser();
    		List<Application> applications = applicationRepository.findByUser(user);
    		applications.sort(Comparator.comparing(Application::getDate).reversed());

    		
            File dbFile = new File(fileName, file.getContentType(), file.getBytes());

            for(Application app: applications ) {
    			if(app.getUser().equals(user)) {
    				dbFile.setApplication(app);
    				break;
    			}
    		}
            return fileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
	}

}
