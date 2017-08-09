package com.stackroute.activitystream.circleutility;

import java.util.List;

public interface CircleDAO 
{
	public boolean createCircle(Circle circle);
	public boolean removeCircle(String circleID);
	public boolean updateCircle(Circle circle);
	public List<Circle> getCircle(String emailid);
	public List<String> getAllCircleID();
}
