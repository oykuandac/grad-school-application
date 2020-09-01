package com.gradschool.controller;

import java.io.Console;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gradschool.model.Application;
import com.gradschool.model.File;
import com.gradschool.model.FileResponse;
import com.gradschool.model.User;
import com.gradschool.service.ApplicationServiceImpl;
import com.gradschool.service.FileService;
import com.gradschool.service.GradOperationsServiceImpl;
import com.helper.Deneme;
import com.helper.FileMerger;
import com.itextpdf.text.BadElementException;


@Controller
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileService dbFileStorageService;
    
    @Autowired
    private ApplicationServiceImpl applicationServiceImpl;
    
    @Autowired
    private GradOperationsServiceImpl gradOperationsService;
    
    @GetMapping({"/upload"})
    public String home2(Model model, HttpServletResponse res) throws IOException {
    	if(gradOperationsService.getOperations().isAppsStartStop() == false) {
    		res.sendRedirect("/application");	
    	}

    		return "jsp/indexupload";
    	
    }


    @PostMapping("/uploadFile")
    public FileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        File dbFile = dbFileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(dbFile.getId())
                .toUriString();

        return new FileResponse(dbFile.getId(), dbFile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        // Load file from database
        File dbFile = dbFileStorageService.getFile(fileId);
        System.out.println(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }
    
    @PostMapping("/uploadFiles")
    public String uploadFiles(@ModelAttribute MultipartFile[] files, RedirectAttributes redirectAttributes) throws IOException, BadElementException {    	
    	MultipartFile[] files2 = new MultipartFile[15];
    	for(int i=0 ; i< files.length; i++) {
    		if(!StringUtils.cleanPath(files[i].getOriginalFilename()).equals("")) {
    			files2[i] = files[i];
    		}
    	}
    	for(int i=0 ; i< files2.length; i++) {
    		if(files2[i] != null) {
    			dbFileStorageService.storeFile(files2[i]);
    		}
    	}
    	//Deneme deneme = new Deneme();
    	//deneme.zipFile(files[0], files[0].getName());
    	//deneme.zipFiles("denemezip", files2);

        return "redirect:/";
    }
    
    @PostMapping("/uploadMultipleFiles")
    public String uploadMultipleFiles(@RequestParam long appId, @RequestParam("files") MultipartFile[] files) {
        System.out.println(files[0]);
    	for(int i = 0;i<files.length;i++) {
    		dbFileStorageService.storeFileForApp(appId,files[i]);
    	}
        
        return "redirect:/";

    }
    
    @GetMapping("/addNewFiles")
    public String addnewfiles(Model model,@RequestParam long appId) {
    	Application app = applicationServiceImpl.findOne(appId);
    	model.addAttribute("app",app);
    	return "thymeleaf/updateFile";
    }
    
    @DeleteMapping("/delete/{fileId}")
    public void delete(@PathVariable String fileId) {
        dbFileStorageService.delete(fileId);
    }
    
	@GetMapping("applications/grad/findFilesByAppId")
	@ResponseBody
	public List<File> findByAppId(long id) {
		return dbFileStorageService.getFilesByApplicationId(id);
	}
	
	@GetMapping("/findFilesByAppId")
	@ResponseBody
	public List<File> findByAppIdApplicant(long id) {
		return dbFileStorageService.getFilesByApplicationId(id);
	}

	
}
