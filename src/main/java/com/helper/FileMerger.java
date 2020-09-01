package com.helper;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import org.apache.pdfbox.multipdf.PDFMergerUtility; 
import org.apache.pdfbox.pdmodel.PDDocument;  



public class FileMerger {
	
	public void mergePdf(MultipartFile[] files) throws IOException, BadElementException {
		
		
		File file0 = convert(files[0]);
		System.out.println(file0.getName());
	    PDDocument doc0 = PDDocument.load(file0); 

	    File file1 = convert(files[1]);
		System.out.println(file1.getName());
	    PDDocument doc1 = PDDocument.load(file1);
	    PDFMergerUtility PDFmerger = new PDFMergerUtility();       

	      //Setting the destination file 
	      PDFmerger.setDestinationFileName("D:\\Coding\\java-oxygen\\Workspace\\merged.pdf"); 

	      //adding the source files 
	      PDFmerger.addSource(file0); 
	      PDFmerger.addSource(file1); 

	      //Merging the two documents 
	      PDFmerger.mergeDocuments(); 
	      System.out.println("Documents merged"); 

	      //Closing the documents 
	      doc0.close(); 
	      doc1.close();           
	
	}
	public File convert(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}


}
