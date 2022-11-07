package br.com.calculate.distance.dto;

import java.io.Serializable;

public class IndexDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	Integer index;

	public IndexDTO () {
		
	}
	
	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "AddressDTO [ index=" + index + "]";
	}

}