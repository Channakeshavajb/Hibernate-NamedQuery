package com.xwokz.hibernate.dao;

import javax.ejb.Handle;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xwokz.hibernate.dto.RestauranDTO;
import com.xworkz.hibernate.util.HibernateUtil;

public class RestaurantDAO {
	public RestaurantDAO() {
		// TODO Auto-generated constructor stub
		System.out.println("created........\t"+this.getClass().getSimpleName());
	}
	
	public void save(RestauranDTO dto) {
		Session session =HibernateUtil.getFactory().openSession();
		Transaction tx=session.beginTransaction();
		System.out.println("saving.........the.........data"+dto);
		
		try {
			System.out.println("data is saving dto\t\t"+dto.getName());
			session.save(dto);
			tx.commit();
			System.out.println("data was saved....successfully\t"+dto.getName());

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("exception created :\t");
			e.printStackTrace();
		}

		finally {

			session.close();
		}
	}
	
	public void update(int id,String newLocation) {
		Session ses=HibernateUtil.getFactory().openSession();
		Transaction tx=ses.beginTransaction();
		try {
			RestauranDTO dtoFromDb=ses.get(RestauranDTO.class, id);
			if(dtoFromDb!=null) {
				dtoFromDb.setLocation(newLocation);
				ses.update(dtoFromDb);
				tx.commit();
				System.out.println("data was saved successfully..........\t"+dtoFromDb.getLocation());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("exception created :\t");
			e.printStackTrace();
		}

		finally {

			ses.close();
			
		}
		
	}

}
