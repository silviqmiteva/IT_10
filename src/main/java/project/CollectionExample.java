package project;

import java.util.ArrayList;
import java.util.List;

public class CollectionExample {
	private static List<User> users = null;
	
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
				user.setName(u.getName());
				user.setId(u.getId());
				user.setAdress(u.getAdress());
				user.setPhone(u.getPhone());
				user.setStreet(u.getStreet());
				user.setTown(u.getTown());
				user.setWork(u.getWork());
			}
		}
		return user;
	}
	
	public void updateUserInfo(int userId,String username,String phone,String street,String town,String work,String address) {
		for(User u : users) {
			if(u.getId()==userId) {
				u.setName(username);
				u.setAdress(address);
				u.setPhone(phone);
				u.setStreet(street);
				u.setTown(town);
				u.setWork(work);
			}
		}
	}
	
	public List<User> getUsers(){
		System.out.println(users);
		return users;
	}
}
