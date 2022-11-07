package br.com.calculate.distance.dto;

import java.io.Serializable;

public class DatasourceDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	String sourcename;
	String attribution;
	String license;
	String url;

	// Getter Methods

	public String getSourcename() {
		return sourcename;
	}

	public String getAttribution() {
		return attribution;
	}

	public String getLicense() {
		return license;
	}

	public String getUrl() {
		return url;
	}

	// Setter Methods

	public void setSourcename(String sourcename) {
		this.sourcename = sourcename;
	}

	public void setAttribution(String attribution) {
		this.attribution = attribution;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Datasource [sourcename=" + sourcename + ", attribution=" + attribution + ", license=" + license
				+ ", url=" + url + "]";
	}

}