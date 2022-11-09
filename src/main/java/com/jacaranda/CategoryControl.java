package com.jacaranda;

import java.util.List;

import org.hibernate.query.Query;

public class CategoryControl {

	public static Category getCategory(int id) {
		Category category = (Category) ConnectionDAO.getSession().get(Category.class,id);
		
		return category;
	}
	

	public static List<Category> getCategory(){
		Query<Category> query = ConnectionDAO.getSession().createQuery("SELECT c FROM com.jacaranda.Category c");
		List<Category> category = (List<Category>) query.getResultList();
		return category;
	}
}
