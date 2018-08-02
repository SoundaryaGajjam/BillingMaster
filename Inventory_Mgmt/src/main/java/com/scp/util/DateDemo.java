package com.scp.util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DateDemo {
public static void main(String[] args) {
	/*DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	String d1=sdf.format(new Date());
	System.out.println(d1);*/
	
	//System.out.println(new Demo(new Date()));
	Session s1=HibernateUtil.getSessionFactory().openSession();
	Transaction tr=s1.beginTransaction();
	Demo d1=new Demo(new Date(), "A");
	s1.save(d1);
	HibernateUtil.FlushNCommit(s1, tr);
	//System.out.println(new Date());
}
}

@Entity
@Table(name="DateDemo_Info")
class Demo{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private String name; 

	public Demo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Demo(Date date, String name) {
		super();
		this.date = date;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Demo [id=" + id + ", date=" + date + ", name=" + name + "]";
	}

	
}