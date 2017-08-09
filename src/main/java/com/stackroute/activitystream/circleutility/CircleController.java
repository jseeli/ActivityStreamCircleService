package com.stackroute.activitystream.circleutility;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircleController 
{
	@Autowired
	CircleDAO circleDAO;
	
	@Autowired
	SubscribeCircleDAO subscribeCircleDAO;
	
	@PostMapping("/createCircle")
	public ResponseEntity<Circle> createCircle(@RequestBody Circle circle)
	{
		
		circle.setCreation_date(new Date());
		if(circleDAO.createCircle(circle))
		{
			circle.statusCode="1025";
			circle.statusDesc="Circle Created";
		}
		else
		{
			circle.statusCode="1026";
			circle.statusDesc="Error happened While Creating Circle.";
		}
		
		return new ResponseEntity<Circle>(circle,HttpStatus.OK);
	}
	
	@GetMapping("/removeCircle/{circleID}")
	public ResponseEntity<Circle> removeCircle(@PathVariable("circleID") String circleID)
	{
		Circle circle=new Circle();
		System.out.println("--Remove Circle--"+circleID);
		if(circleDAO.removeCircle(circleID))
		{
			circle.statusCode="1021";
			circle.statusDesc="Successfully Circle Deleted";
		}
		else
		{
			circle.statusCode="1022";
			circle.statusDesc="Problem Occured during Deletion";
		}
		
		return new ResponseEntity<Circle>(circle,HttpStatus.OK);
	}
	
	@PostMapping("/updateCircle")
	public ResponseEntity<Circle> updateCircle(@RequestBody Circle circle)
	{
		
		if(circleDAO.updateCircle(circle))
		{
			circle.statusCode="1023";
			circle.statusDesc="Successfully Circle Updated";
		}
		else
		{
			circle.statusCode="1024";
			circle.statusDesc="Problem Occured While Updation";
		}
		
		return new ResponseEntity<Circle>(circle,HttpStatus.OK);
	}
	
	@GetMapping("/getCircleByUser/{emailid}")
	public ResponseEntity<List<Circle>> getCircleByUser(@PathVariable("emailid") String emailid)
	{
		emailid=emailid+".com";
		List<Circle> listCircle=circleDAO.getCircle(emailid);
		return new ResponseEntity<List<Circle>>(listCircle,HttpStatus.OK);
	}
	
	@GetMapping("/getAllCircles")
	public ResponseEntity<List<String>> getAllCircles()
	{
		List<String> listCircleId=circleDAO.getAllCircleID();
		return new ResponseEntity<List<String>>(listCircleId,HttpStatus.OK);
	}
	
}
