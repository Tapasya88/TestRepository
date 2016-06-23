package com.demo.jdbc.db;


public class Employee {
	
	
	private String exampleInputName;
	private String exampleInputEmail;
	private String exampleInputPhone;
	
	private String exampleInputLocation;
	private String exampleInputPosition;
	private String exampleInputClient;
	
	@Override
	public String toString() {
		return "Employee [exampleInputName=" + exampleInputName
				+ ", exampleInputEmail=" + exampleInputEmail
				+ ", exampleInputPhone=" + exampleInputPhone
				+ ", exampleInputLocation=" + exampleInputLocation
				+ ", exampleInputPosition=" + exampleInputPosition
				+ ", exampleInputClient=" + exampleInputClient + "]";
	}
	
	public String getExampleInputName() {
		return exampleInputName;
	}
	public void setExampleInputName(String exampleInputName) {
		this.exampleInputName = exampleInputName;
	}
	public String getExampleInputEmail() {
		return exampleInputEmail;
	}
	public void setExampleInputEmail(String exampleInputEmail) {
		this.exampleInputEmail = exampleInputEmail;
	}
	public String getExampleInputPhone() {
		return exampleInputPhone;
	}
	public void setExampleInputPhone(String exampleInputPhone) {
		this.exampleInputPhone = exampleInputPhone;
	}
	public String getExampleInputLocation() {
		return exampleInputLocation;
	}
	public void setExampleInputLocation(String exampleInputLocation) {
		this.exampleInputLocation = exampleInputLocation;
	}
	public String getExampleInputPosition() {
		return exampleInputPosition;
	}
	public void setExampleInputPosition(String exampleInputPosition) {
		this.exampleInputPosition = exampleInputPosition;
	}
	public String getExampleInputClient() {
		return exampleInputClient;
	}
	public void setExampleInputClient(String exampleInputClient) {
		this.exampleInputClient = exampleInputClient;
	}
	

}