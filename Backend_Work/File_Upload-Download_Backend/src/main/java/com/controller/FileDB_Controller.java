package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.entity.FileDB;
import com.exception.ResourceNotFoundException;
import com.payload.ApiResponse;
import com.repository.FileDB_Repository;
import com.response.ResponseFile;
import com.response.ResponseMessage;
import com.service.FileDB_Service;


@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/file")		//  http://localhost:8181/file
public class FileDB_Controller {

	@Autowired
	private FileDB_Service fileService;
	
	@Autowired
	private FileDB_Repository fileDBRepo;


//================================================================================================================
	
	//  Upload-File Operation: Op:1
	
	//  http://localhost:8181/file/file-upload
	
	@PostMapping("/file-upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		System.out.println("Hello....1");
		try {
			// Operation for localDateTime
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
			String formattedDate = myDateObj.format(myFormatObj);
			System.out.println(formattedDate);
			
			// Storing both file & localDateTime
			fileService.store(file, formattedDate);
			
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
				Thread.sleep(3000);  // delay of 3 sec...
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	 }

//================================================================================================================

	//  View All-Files Operation: Op:2
	
	//  http://localhost:8181/file/files
	
	@GetMapping("/files")
	public ResponseEntity<List<ResponseFile>> getListFiles() {
		List<ResponseFile> files = fileService.getAllFiles().map(dbFile -> {
			String fileDownloadUri = ServletUriComponentsBuilder
					.fromCurrentContextPath()
					.path("/files/")
					.toUriString();


			return new ResponseFile(
						dbFile.getName(),
						fileDownloadUri,
						dbFile.getType(),
						dbFile.getData().length);
			}).collect(Collectors.toList());


		return ResponseEntity.status(HttpStatus.OK).body(files);
  }
	
//================================================================================================================
	
	 //  Retrieve Operation:-  Op:3
	  
 	 //	 http://localhost:8181/file/files-getAll
 
	  @GetMapping("/files-getAll")
	  public ResponseEntity<List<FileDB>> getAllPassenger() {
	    List<FileDB> files = new ArrayList<FileDB>();
	
	    	fileDBRepo.findAll().forEach(files::add);
		
		    if (files.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		
		    return new ResponseEntity<>(files, HttpStatus.OK);
	  }
	  
//================================================================================================================


	//  Download-File Operation: Op:4
	
	//  http://localhost:8181/file/file-download/{id}
	
	@GetMapping("/file-download/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable String id) {
		FileDB fileDB = fileService.getFile(id);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
				.body(fileDB.getData());
	}
	

//================================================================================================================

	  //  Delete Operation by Id:-   Op:5
	  
	  //  http://localhost:8181/file/file-delete/{id}
	  
	  @DeleteMapping("/file-delete/{id}")
	  public ResponseEntity<ApiResponse> deleteFile(@PathVariable("id") String id) {
		  
		  FileDB file_id = fileDBRepo.findById(id)
			        .orElseThrow(() -> new ResourceNotFoundException("Not found File with Id = " + id));
		  
		  fileDBRepo.deleteById(id);
	    
	    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  return new ResponseEntity<ApiResponse>(new ApiResponse("File deleted Successfully", true), HttpStatus.OK);
	  }
		
	
//================================================================================================================

}

