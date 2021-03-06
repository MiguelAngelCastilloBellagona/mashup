package es.udc.mashup.productnews.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Entry {
	
	private String id;
	private String title;
	private String summary;
	private Date updated;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	public String getUpdatedString(){
		DateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        return formatter.format(this.updated);
	}

}
