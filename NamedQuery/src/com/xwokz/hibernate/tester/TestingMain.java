package com.xwokz.hibernate.tester;

import java.util.Collection;

import javax.persistence.NamedQuery;

import com.xwokz.hibernate.dao.NamedDAO;
import com.xworkz.hibernate.util.HibernateUtil;

public class TestingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	NamedDAO namedDAO=new NamedDAO();
	Collection<Object[]> obj= namedDAO.getMaxOfIdAndNameByNoOfRooms(15);
	for (Object[] objects : obj) {
		System.out.println(objects[0]);
		System.out.println(objects[1]);
	}
	HibernateUtil.getFactory().close();
	}
	

}
