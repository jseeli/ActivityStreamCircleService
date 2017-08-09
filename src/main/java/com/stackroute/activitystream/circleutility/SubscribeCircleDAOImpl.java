package com.stackroute.activitystream.circleutility;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository("subscribeCircleDAO")
public class SubscribeCircleDAOImpl implements SubscribeCircleDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	public SubscribeCircleDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	@Override
	public boolean subscribeToCircle(SubscribeCircle subscribeCircle) 
	{
		System.out.println("--Controller - emaiid:"+subscribeCircle.getEmail_id());
		System.out.println("Circle ID"+subscribeCircle.getCircle_id());
		try
		{
		sessionFactory.getCurrentSession().save(subscribeCircle);
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
	public boolean unSubscribeFromCircle(int subscribeID) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			SubscribeCircle subscribeCircle=(SubscribeCircle)session.get(SubscribeCircle.class,subscribeID);
			session.close();
			subscribeCircle.setStatus("N");
			sessionFactory.getCurrentSession().saveOrUpdate(subscribeCircle);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	@Transactional
	public List<SubscribeCircle> getSubscribeCircles(String emailID)
	{
		try
		{
			Query query=sessionFactory.getCurrentSession().createQuery("from SubscribeCircle where email_id=:emailid");
			query.setParameter("emailid",emailID);
			List<SubscribeCircle> listCircles=query.list();
			System.out.println(listCircles);
			return listCircles;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
