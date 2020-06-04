package project;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="users")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionExample {
	@XmlElement(name = "user")
	private static List<User> users = null;
	static CollectionExample instance = null;
	static int index=1;

	private static String fileXMLName = "C:\\Users\\Silvia\\eclipse-workspace\\projects\\upraj8\\src\\main\\webapp\\users\\users.xml";
	
	public CollectionExample() {
		if(users == null) {
			users = new ArrayList<User>();
		}
	}
	
	public void addUser(User user) {
		if(user != null) {
			users.add(user);
			System.out.println(user);
		}
	}
	
	public boolean checkIfUserExists(User user) {
		boolean userExists = false;
		for(User u : users) {
			if(u.getName().equals(user.getName()) && u.getPassword().equals(user.getPassword())) {
				userExists = true;
				System.out.println(userExists);
			}
		}
		return userExists;
	}
	
	public int getUserID(User user) {
		int userId=0;
		for(User u : users) {
			if(u.getName().equals(user.getName()) && u.getPassword().equals(user.getPassword())) {
				userId = u.getId();
			}
		}
		return userId;
	}
	
	public User getUserInfo(int userId) {
		User user = new User();
		for(User u : users) {
			if(u.getId()==userId) {
				user.setPassword(u.getPassword());
				user.setName(u.getName());
				user.setId(u.getId());
				user.setAdress(u.getAdress());
				user.setPhone(u.getPhone());
				user.setStreet(u.getStreet());
				user.setTown(u.getTown());
				user.setWork(u.getWork());
				user.setDescription(u.getDescription());
				user.setJava(u.getJava());
				user.setHtml(u.getHtml());
			}
		}
		return user;
	}
	
	public void updateUserInfo(int userId,String username,String phone,String street,String town,String work,String address,String description,String java,String html) {
		for(User u : users) {
			if(u.getId()==userId) {
				if(username.length()>0) {
					u.setName(username);
				}if(address.length()>0) {
					u.setAdress(address);
				}if(phone.length()>0) {
					u.setPhone(phone);
				}if(street.length()>0) {
					u.setStreet(street);
				}if(town.length()>0) {
					u.setTown(town);
				}if(work.length()>0) {
					u.setWork(work);
				}if(description.length()>0){
					u.setDescription(description);
				}if(java.length()>0) {
					u.setJava(java);
				}if(html.length()>0) {
					u.setHtml(html);
				}
			}
		}
	}
	public List<User> getUsers(){
		System.out.println(users);
		return users;
	}
	
	public void update(User person) {
		XMLFile workFile = new XMLFile();
		try {
			workFile.writeToXMLFile(fileXMLName, person);
		}catch(JAXBException e){
			e.printStackTrace();
		}
	}
	
	static public CollectionExample getInstance() {
		if(instance == null) {
			XMLFile workerFile = new XMLFile();
			try {
				instance = workerFile.readFromXMLFile(fileXMLName);
				instance.index = instance.users.size()+1;
			}catch(FileNotFoundException | JAXBException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
}
