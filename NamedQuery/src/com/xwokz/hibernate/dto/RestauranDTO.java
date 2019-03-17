package com.xwokz.hibernate.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Restaurant_details")
@NamedQueries({
		@NamedQuery(name = "fetchBy", query = "select max(id),name from RestauranDTO where noOfRooms=:rooms group by noOfRooms"),
		@NamedQuery(name = "fetchByNAme", query = "select count(*) from RestauranDTO where name=:named"),
		@NamedQuery(name = "fetchNoOfRooms", query = "select count(noOfRooms) from RestauranDTO"),
		@NamedQuery(name = "fetchCount", query = "select count(*) from RestauranDTO"),
		@NamedQuery(name = "selectAll", query = "select r from RestauranDTO r"),
		@NamedQuery(name = "fetchLocation", query = "select r.location from RestauranDTO r where name=:rname"),
		@NamedQuery(name = "selectLocRooms", query = "select r.location, r.noOfRooms from RestauranDTO r where name=:rname") })
public class RestauranDTO implements Serializable {

	@Id
	@GenericGenerator(name = "hotel", strategy = "increment")
	@GeneratedValue(generator = "hotel")
	@Column(name = "R_id")
	private int id;
	@Column(name = "Name")
	private String name;
	@Column(name = "Location")
	private String location;
	@Column(name = "No_of_rooms")
	private int noOfRooms;
	@Column(name = "Veg")
	private boolean veg;

	public RestauranDTO() {
		// TODO Auto-generated constructor stub
		System.out.println("created.....\t" + this.getClass().getSimpleName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public boolean isVeg() {
		return veg;
	}

	public void setVeg(boolean veg) {
		this.veg = veg;
	}

	@Override
	public String toString() {
		return "RestauranDTO [id=" + id + ", name=" + name + ", location=" + location + ", noOfRooms=" + noOfRooms
				+ ", veg=" + veg + "]";
	}

}
