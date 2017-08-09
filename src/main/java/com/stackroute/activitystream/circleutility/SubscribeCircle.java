package com.stackroute.activitystream.circleutility;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class SubscribeCircle extends BaseDomain
{
	@Id
	private int subscribe_id;
	
	private String circle_id;
	
	private String email_id;
	
	private String status;
	
	private Date subscribe_date;

	public int getSubscribe_id() {
		return subscribe_id;
	}

	public void setSubscribe_id(int subscribe_id) {
		this.subscribe_id = subscribe_id;
	}

	public String getCircle_id() {
		return circle_id;
	}

	public void setCircle_id(String circle_id) {
		this.circle_id = circle_id;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getSubscribe_date() {
		return subscribe_date;
	}

	public void setSubscribe_date(Date subscribe_date) {
		this.subscribe_date = subscribe_date;
	}
	
	
}
