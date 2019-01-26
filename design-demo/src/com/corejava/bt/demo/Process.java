package com.corejava.bt.demo;

public class Process {
	
	private Long id;
	private String fileName;
	private boolean flag;
	
	public Process(Long id, String fileName, boolean flag) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.flag = flag;
	}

	public Process(boolean flag) {
		super();
		this.flag = flag;
	}

	public Process() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Process [id=" + id + ", fileName=" + fileName + ", flag=" + flag + "]";
	}
	
}
