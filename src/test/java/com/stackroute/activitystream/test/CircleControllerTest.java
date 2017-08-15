package com.stackroute.activitystream.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.stackroute.activitystream.CircleServiceBoot;
import com.stackroute.activitystream.circleutility.Circle;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {CircleServiceBoot.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT,classes=CircleServiceBoot.class)
public class CircleControllerTest 
{

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	
	@Before
	public void setup() throws Exception 
	{
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testCaseForCreateCircle()throws Exception
	{		
		Circle circle=new Circle();
		HttpEntity<Circle> entity = new HttpEntity<Circle>(circle, headers);
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8087/createUser",HttpMethod.POST, entity, String.class);
		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
		assertTrue(actual.contains("/createUser"));
	}
	
	
	
}
