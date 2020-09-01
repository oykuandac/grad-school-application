package com.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.mail.Multipart;

import org.springframework.web.multipart.MultipartFile;

public class Deneme {
	
	
	public static void main(String[] args) throws IOException {
        String sourceFile = "zipTest";
        FileOutputStream fos = new FileOutputStream("dirCompressed.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        File fileToZip = new File(sourceFile);
 
        zipOut.close();
        fos.close();
    }
 
    public static void zipFile(MultipartFile fileToZip, String fileName) throws IOException {
    	try {
    		File convFile = new File( fileToZip.getOriginalFilename() );
            FileOutputStream fos = new FileOutputStream( convFile );
            fos.write( fileToZip.getBytes() );
            fos.close();    		
  		
            String zipFileName = convFile.getName().concat(".zip");
            
            System.out.println(zipFileName);
            FileOutputStream fos2 = new FileOutputStream(zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos2);
 
            zos.putNextEntry(new ZipEntry(convFile.getName()));
            byte[] bytes = fileToZip.getBytes();
 
        } catch (FileNotFoundException ex) {
            System.err.format("The file %s does not exist");
        } catch (IOException ex) {
            System.err.println("I/O error: " + ex);
        }
    }
    
    public static void zipFiles(String name, MultipartFile[] files) {
        try {
            String zipFileName = name.concat(".zip");
 
            FileOutputStream fos = new FileOutputStream(zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos);
 
            for (MultipartFile aFile : files) {
            	if(aFile!=null) {
            		File convFile = new File( aFile.getOriginalFilename() );
                    FileOutputStream foss = new FileOutputStream( convFile );
                    foss.write( aFile.getBytes() );
                    foss.close(); 
                    zos.putNextEntry(new ZipEntry(convFile.getName()));         	
                    byte[] bytes = aFile.getBytes();
                    zos.write(bytes, 0, bytes.length);
                    zos.closeEntry();
            	}
            }
 
            zos.close();
 
        } catch (FileNotFoundException ex) {
            System.err.println("A file does not exist: " + ex);
        } catch (IOException ex) {
            System.err.println("I/O error: " + ex);
        }
    }
    

 
 
}
