package com.xwokz.hibernate.tester;

import com.xwokz.hibernate.dao.RestaurantDAO;
import com.xworkz.hibernate.util.HibernateUtil;

public class UpdateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestaurantDAO dao=new RestaurantDAO();
		dao.update(23, "darmasthala");
		HibernateUtil.getFactory().close();

	}

}
