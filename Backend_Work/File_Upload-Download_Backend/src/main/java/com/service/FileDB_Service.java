package com.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.entity.FileDB;
import com.repository.FileDB_Repository;

@Service
public class FileDB_Service {

	@Autowired
	private FileDB_Repository fileDBRepo;

// ==========================================================================================================

	//  Upload-File Operation: Op:1
	
	public FileDB store(MultipartFile file, String date_time) throws IOException {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes(), date_time);
		System.out.println("Hello....2");

		return fileDBRepo.save(FileDB);
	}
	
// ==========================================================================================================

	//  View All-Files Operation: Op:2

	public Stream<FileDB> getAllFiles() {
		return fileDBRepo.findAll().stream();
	}
	
// ==========================================================================================================

	//  Download-File Operation: Op:4
	
	public FileDB getFile(String id) {
		return fileDBRepo.findById(id).get();
	}

// ==========================================================================================================
// ==========================================================================================================


}






