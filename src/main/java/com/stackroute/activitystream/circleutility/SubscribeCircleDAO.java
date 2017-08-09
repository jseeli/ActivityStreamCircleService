package com.stackroute.activitystream.circleutility;

import java.util.List;


public interface SubscribeCircleDAO 
{
	public boolean subscribeToCircle(SubscribeCircle subscribeCircle);
	public boolean unSubscribeFromCircle(int subscribeID);
	public List<SubscribeCircle> getSubscribeCircles(String emailID);
}
