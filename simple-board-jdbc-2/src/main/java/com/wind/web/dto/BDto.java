package com.wind.web.dto;

public class BDto {

	int bId;
	String bName;
	String bContent;
	
	public BDto() { }

	public BDto(int bId, String bName, String bContent) {

		this.bId = bId;
		this.bName = bName;
		this.bContent = bContent;
	}

	public int getbId( ) { 
		return bId; 
	}
	
	public String getbName( ) { 
		return bName; 
	}
	
	public String getbContent( ) { 
		return bContent;
	}
	

	public void setbId(int bId) {
		this.bId = bId;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

}