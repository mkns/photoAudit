package com.kennyscott.photoaudit.entity;

public class Photo {

	private String file;
	private String filesize;
	private String name;
	private String thumbnail;
	private String path;
	private String monthyear;
	private String year;

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getFile() {
		return file;
	}
	
	public void setFile(String file) {
		this.file = file;
	}
	
	public String getFilesize() {
		return filesize;
	}
	
	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getMonthyear() {
		return monthyear;
	}
	
	public void setMonthyear(String monthyear) {
		this.monthyear = monthyear;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
}
