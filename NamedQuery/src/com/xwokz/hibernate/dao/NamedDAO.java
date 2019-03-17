package com.xwokz.hibernate.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.xwokz.hibernate.dto.RestauranDTO;
import com.xworkz.hibernate.util.HibernateUtil;

public class NamedDAO {
	public NamedDAO() {
		// TODO Auto-generated constructor stub
		System.out.println("created............." + this.getClass().getSimpleName());
	}

	public Collection<Object[]> getMaxOfIdAndNameByNoOfRooms(int noOfRooms) {
		Session session = HibernateUtil.getFactory().openSession();
		System.out.println("getting data with args.......\t" + noOfRooms);
		try {
			Query query = session.getNamedQuery("fetchBy");
			query.setParameter("rooms", noOfRooms);
			List<Object[]> list = query.list();
			return list;

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("exception created :\t");
			e.printStackTrace();
		}

		finally {

			session.close();
		}
		return null;

	}

	public Long getCountByName(String name) {
		Session session = HibernateUtil.getFactory().openSession();
		try {

			Query query = session.getNamedQuery("fetchByNAme");
			query.setParameter("named", name);
			Long nameRes = (Long) query.uniqueResult();
			System.out.println("the\t" + name + "\t count is\t" + nameRes);

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("exception created :\t");
			e.printStackTrace();
		}

		finally {
			session.close();
		}
		return 0L;
	}

	public Long getSumNoOfRooms() {
		Session session = HibernateUtil.getFactory().openSession();
		try {
			Query query = session.getNamedQuery("fetchNoOfRooms");
			Long sum = (Long) query.uniqueResult();
			System.out.println("the total number of rooms is:\t" + sum);

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("exception created :\t");
			e.printStackTrace();
		}

		finally {
			session.close();
		}
		return 0l;
	}

	public Long getCount() {
		Session session = HibernateUtil.getFactory().openSession();
		try {
			Query query = session.getNamedQuery("fetchCount");
			Long count = (Long) query.uniqueResult();
			System.out.println("count of RestauranDTO is\t" + count);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("exception created :\t");
			e.printStackTrace();
		}

		finally {
			session.close();
		}
		return 0l;
	}

	public List<RestauranDTO> fetchAll() {
		Session session = HibernateUtil.getFactory().openSession();
		try {
			System.out.println("invoked fetchAll(...)");
			Query query = session.getNamedQuery("selectAll");
			List<RestauranDTO> list = query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("exception created :\t");
			e.printStackTrace();
		}

		finally {
			session.close();
		}
		return null;
	}

	public Collection<String> fetchLocationColumnByName(String name) {
		Session session = HibernateUtil.getFactory().openSession();
		try {
			Query query = session.getNamedQuery("fetchLocation");
			query.setParameter("rname", name);
			List<String> list = query.list();
			return list;

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("exception created :\t");
			e.printStackTrace();
		}

		finally {
			session.close();
		}
		return null;
	}

	public List<Object[]> fetchLocationAndNoOfRooms(String name) {
		Session session = HibernateUtil.getFactory().openSession();
		try {
			Query query = session.getNamedQuery("selectLocRooms");
			query.setParameter("rname", name);
			List<Object[]> list = (List<Object[]>) query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("exception created :\t");
			e.printStackTrace();
		}

		finally {
			session.close();
		}
		return null;
	}

}
