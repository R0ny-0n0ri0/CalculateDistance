package br.com.calculate.distance.dto;

import java.io.Serializable;

public class QueryDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	String text;
	ParsedDTO parsed;

	// Getter Methods

	public String getText() {
		return text;
	}

	public ParsedDTO getParsed() {
		return parsed;
	}

	// Setter Methods

	public void setText(String text) {
		this.text = text;
	}

	public void setParsed(ParsedDTO parsed) {
		this.parsed = parsed;
	}

	@Override
	public String toString() {
		return "Query [text=" + text + ", parsed=" + parsed + "]";
	}

}