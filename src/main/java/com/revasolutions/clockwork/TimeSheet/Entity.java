package com.revasolutions.clockwork.TimeSheet;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Entity {

	private String id;	
	private String emailAddress;
	private String timeSpent;
	private static int totalTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getTimeSpent() {
		return timeSpent;
	}
	public void setTimeSpentSeconds(String timeSpentSeconds) {
		Entity.totalTime+=Integer.parseInt(timeSpentSeconds)/(60*60);
		this.timeSpent = String.valueOf(Integer.parseInt(timeSpentSeconds)/(60*60));
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + ", emailAddress=" + emailAddress + ", timeSpent=" + timeSpent + " hours]\n ";
	}

	public static int getTotalTime() {
		return totalTime;
	}
	
	@SuppressWarnings("unchecked")
	@JsonProperty("author")
	private void unpackNested(Map<String,Object> author) {
		this.emailAddress = (String)author.get("emailAddress");
	}




}
