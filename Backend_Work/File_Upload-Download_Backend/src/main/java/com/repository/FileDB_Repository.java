package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.FileDB;

@Repository
public interface FileDB_Repository extends JpaRepository<FileDB, String> {


}
