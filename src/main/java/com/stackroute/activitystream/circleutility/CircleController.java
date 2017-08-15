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
		
	@PostMapping("/createCircle")
	public ResponseEntity<Circle> createCircle(@RequestBody Circle circle)
	{
		
		circle.setCreation_date(new Date());
		
		if(circleDAO.createCircle(circle))
		{
			circle.setStatusCode("1025");
			circle.setStatusDesc("Circle Created");
		}
		else
		{
			circle.setStatusCode("1026");
			circle.setStatusDesc("Error happened While Creating Circle.");
		}
		
		return new ResponseEntity<Circle>(circle,HttpStatus.OK);
	}
	
	@GetMapping("/removeCircle/{circleID}")
	public ResponseEntity<Circle> removeCircle(@PathVariable("circleID") String circleID)
	{
		//Avoid using 'new' key word to create instance.  use @AutowWired
		Circle circle=new Circle();
		System.out.println("--Remove Circle--"+circleID);
		if(circleDAO.removeCircle(circleID))
		{
			circle.setStatusCode("1021");
			circle.setStatusDesc("Problem Occured during Deletion");
		}
		else
		{
			circle.setStatusCode("1022");
			circle.setStatusDesc("Circle Created");
		}
		
		return new ResponseEntity<Circle>(circle,HttpStatus.OK);
	}
	
	@PostMapping("/updateCircle")
	public ResponseEntity<Circle> updateCircle(@RequestBody Circle circle)
	{
		
		if(circleDAO.updateCircle(circle))
		{
			circle.setStatusCode("1023");
			circle.setStatusDesc("Successfully Circle Updated");
			
		}
		else
		{
			circle.setStatusCode("1024");
			circle.setStatusDesc("Problem Occured While Updation");
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
