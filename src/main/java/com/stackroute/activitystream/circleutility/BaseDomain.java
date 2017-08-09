package com.stackroute.activitystream.circleutility;

import javax.persistence.Transient;

public class BaseDomain 
{
	@Transient
	public String statusCode;
	
	@Transient
	public String statusDesc;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	
	

}
