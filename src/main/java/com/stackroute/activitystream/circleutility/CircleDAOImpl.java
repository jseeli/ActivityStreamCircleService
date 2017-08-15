package com.stackroute.activitystream.circleutility;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository("circleDAO")
public class CircleDAOImpl implements CircleDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public CircleDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	@Override
	public boolean createCircle(Circle circle) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(circle);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;	
		}
		
	}

	@Transactional
	@Override
	public boolean removeCircle(String circleID) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Circle circle=session.get(Circle.class,circleID);
			session.delete(circle);
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception e"+e);
			return false;	
		}
	}

	@Transactional
	@Override
	public boolean updateCircle(Circle circle) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(circle);
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
	}

	@Transactional
	@Override
	//What is the use of this method?  Do you want to know what are the circles created by me?
	//The circle created by the user itself
	public List<Circle> getCircle(String emailid) 
	{
		Query query=sessionFactory.getCurrentSession().createSQLQuery("select * from circle where circle_owner='"+emailid+"'");
		List<Circle> listCircle=(List<Circle>)query.list();
		return listCircle;
	}

	@Transactional
	@Override
	public List<String> getAllCircleID() 
	{
		Query query=sessionFactory.getCurrentSession().createQuery("select circle_id from Circle");
		List<String> listCircleId=(List<String>)query.list();
		return listCircleId;
	}
	
	

	
}
