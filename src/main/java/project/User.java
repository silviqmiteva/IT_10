package project;

import java.io.Serializable;

public class User implements Serializable {

	private String name;
	private String password;
	private int id;
	private String adress;
	private String work;
	private String phone;
	private String town;
	private String street;
	
	public User() { }
	public User(int id,String name,String pass) {
		this.id = id;
		this.name = name;
		this.password = pass;
	}
	
	public User(String name,String pass) {
		this.name = name;
		this.password = pass;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public String getWork() {
		return work;
	}
	
	public void setWork(String work) {
		this.work = work;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getTown() {
		return town;
	}
	
	public void setTown(String town) {
		this.town = town;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id +",name=" + name + ",password=" + password + "]";
	}

	
}
