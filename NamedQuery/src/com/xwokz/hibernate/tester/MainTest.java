package com.xwokz.hibernate.tester;

import com.xwokz.hibernate.dao.RestaurantDAO;
import com.xwokz.hibernate.dto.RestauranDTO;
import com.xworkz.hibernate.util.HibernateUtil;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestauranDTO dto = new RestauranDTO();
		dto.setName("atithi");
		dto.setLocation("tumkur");
		dto.setNoOfRooms(9);
		dto.setVeg(true);

		RestaurantDAO dao=new RestaurantDAO();
		dao.save(dto);
		HibernateUtil.getFactory().close();
	}

}
