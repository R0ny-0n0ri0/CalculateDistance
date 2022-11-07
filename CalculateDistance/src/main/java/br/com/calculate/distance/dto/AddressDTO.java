package br.com.calculate.distance.dto;

import java.io.Serializable;

public class AddressDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	String adress;

	public AddressDTO () {
		
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "AddressDTO [adress=" + adress + "]";
	}
	
}