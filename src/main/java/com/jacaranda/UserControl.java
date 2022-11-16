package com.jacaranda;
import java.util.Iterator;
import java.util.List;


import org.hibernate.query.Query;
public class UserControl {
	
	//Valida si el usuario es valido
	public static boolean isValidUser(String nick, String password) {
		boolean valid = false;
		User user = getUser(nick, password);
		if(user != null) {
			valid = true;
		}
		return valid;
	}
	
	//valida si el usuario es administrador
	public static boolean isAdministrator(String nick, String password){
		boolean valid = false;
		User user = getUser(nick,password);
		if(user.isAdministrator()) {
			valid =true;
		}
		return valid;
	}
	
	//odtiene un usuario
	public static User getUser(String nick, String password){
		User u = null;
			Query<User> query = ConnectionDAO.getSession().createQuery("SELECT h FROM com.jacaranda.User h");
			List<User> userList = (List <User>) query.getResultList();
			
			Iterator <User> pointer = userList.iterator();
			User aux = null;
			boolean found = false;
			while(pointer.hasNext()&&!found) {
				aux = pointer.next();
				if(aux.getNick().equals(nick)&&aux.getPassword().equals(password)) {
					found = true;
					u = aux;
				}
			}
	
		return u;
	}
	
	//añadir usuario
	public static boolean addUser(User user) {
		boolean add = false;
		try {
			ConnectionDAO.getSession().getTransaction().begin();
			ConnectionDAO.getSession().save(user);
			ConnectionDAO.getSession().getTransaction().commit();
			add=true;
		} catch (Exception e) {
			ConnectionDAO.getSession().getTransaction().rollback();
		}
		return add;
	}
}
