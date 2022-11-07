package br.com.calculate.distance.dto;

import java.io.Serializable;

public class UrlDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;

	String id; 
	
	String status;
	
	String url;
	
	public UrlDTO() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "UrlDTO [id=" + id + ", status=" + status + ", url=" + url + "]";
	}
	
	
}
