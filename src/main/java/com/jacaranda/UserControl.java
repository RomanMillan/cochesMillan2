package com.jacaranda;

public class UserControl {
	
	//Metodo leer Usuario
	public static boolean validUser(String password) {
		boolean valid = false;
		User u = (User) ConnectionDAO.getSession().get(User.class,password);
		if(u != null) {
			valid = true;
		}
		return valid;
	}
	
	public static boolean addUser(User user) {
		boolean add = false;
		try {
			ConnectionDAO.getSession().getTransaction().begin();
			ConnectionDAO.getSession().save(user);
			ConnectionDAO.getSession().getTransaction().commit();
			add=true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return add;
	}
}
