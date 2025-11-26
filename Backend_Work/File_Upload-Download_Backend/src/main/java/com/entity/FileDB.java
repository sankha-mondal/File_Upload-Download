package com.entity;

import java.util.Arrays;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;


@Entity
@Table(name = "files")
public class FileDB {
	
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")  // Auto generated String Id.
  private String id;

  private String name;

  private String type;

  @Lob
  private byte[] data;    // Do in MySQL: alter table <table_name> modify <col_name> longblob;
  
  private String date_time;

	public String getDate_time() {
		return date_time;
	}
	
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public byte[] getData() {
		return data;
	}
	
	public void setData(byte[] data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "FileDB [id=" + id + ", name=" + name + ", type=" + type + ", data=" + Arrays.toString(data) + ", date_time="
				+ date_time + "]";
	}
	
	public FileDB(String name, String type, byte[] data, String date_time) {
		this.name = name;
		this.type = type;
		this.data = data;
		this.date_time = date_time;
	}
	
	public FileDB() {
		super();
		// TODO Auto-generated constructor stub
	}


}
