package project;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class User implements Serializable {

	private String name;
	private String password;
	private int id;
	private String address;
	private String work;
	private String phone;
	private String town;
	private String street;
	private String description;
	private String java;
	private String html;
	
//	private Map<String,String> jobSkills = new HashMap<String,String>();
//	
//	public void addJobsSkills(String key, String value) {
//		jobSkills.put(key, value);
//	}
	
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
		return address;
	}
	
	public void setAdress(String address) {
		this.address = address;
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getJava() {
		return java;
	}
	
	public void setJava(String java) {
		this.java = java;
	}
	
	public String getHtml() {
		return html;
	}
	
	public void setHtml(String html) {
		this.html = html;
	}
	
	
}
