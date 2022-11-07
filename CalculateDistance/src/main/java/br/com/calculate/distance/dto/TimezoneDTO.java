package br.com.calculate.distance.dto;

import java.io.Serializable;

public class TimezoneDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	String name;
	String offset_STD;
	float offset_STD_seconds;
	String offset_DST;
	float offset_DST_seconds;

	// Getter Methods

	public String getName() {
		return name;
	}

	public String getOffset_STD() {
		return offset_STD;
	}

	public float getOffset_STD_seconds() {
		return offset_STD_seconds;
	}

	public String getOffset_DST() {
		return offset_DST;
	}

	public float getOffset_DST_seconds() {
		return offset_DST_seconds;
	}

	// Setter Methods

	public void setName(String name) {
		this.name = name;
	}

	public void setOffset_STD(String offset_STD) {
		this.offset_STD = offset_STD;
	}

	public void setOffset_STD_seconds(float offset_STD_seconds) {
		this.offset_STD_seconds = offset_STD_seconds;
	}

	public void setOffset_DST(String offset_DST) {
		this.offset_DST = offset_DST;
	}

	public void setOffset_DST_seconds(float offset_DST_seconds) {
		this.offset_DST_seconds = offset_DST_seconds;
	}

	@Override
	public String toString() {
		return "Timezone [name=" + name + ", offset_STD=" + offset_STD + ", offset_STD_seconds=" + offset_STD_seconds
				+ ", offset_DST=" + offset_DST + ", offset_DST_seconds=" + offset_DST_seconds + "]";
	}

}