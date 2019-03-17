package com.xwokz.hibernate.tester;

import java.util.Collection;
import java.util.List;

import com.xwokz.hibernate.dao.NamedDAO;
import com.xwokz.hibernate.dao.RestaurantDAO;
import com.xwokz.hibernate.dto.RestauranDTO;
import com.xworkz.hibernate.util.HibernateUtil;

public class GetCountByNameTest {

	public static void main(String[] args) {

		NamedDAO dao = new NamedDAO();
		dao.getCountByName("kamath");
		dao.getSumNoOfRooms();
		dao.getCount();

		List<RestauranDTO> list = dao.fetchAll();
		list.forEach(e -> System.out.println(e));

		Collection<String> lists = dao.fetchLocationColumnByName("udupi");
		lists.forEach(e -> System.out.println(e));

		List<Object[]> list2 = dao.fetchLocationAndNoOfRooms("kadamba");
		list2.forEach(e -> {
			System.out.print(e[0] + "\t");
			System.out.println(e[1]);
		});
		/*
		 * for (Object[] objects : list2) { System.out.print(objects[0]+"\t");
		 * System.out.println(objects[1]); }
		 */
		HibernateUtil.getFactory().close();

	}

}
