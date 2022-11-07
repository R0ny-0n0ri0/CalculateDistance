package br.com.calculate.distance.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class MatrixAddressDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	ArrayList<AddressDTO> address = new ArrayList<AddressDTO>();
	ArrayList<IndexDTO> index = new ArrayList<IndexDTO>();
	ArrayList<ReturnDTO> returnDTO = new ArrayList<ReturnDTO>();

	
	
	public MatrixAddressDTO() {
		
	}

	public ArrayList<AddressDTO> getAddress() {
		return address;
	}

	public void setAddress(ArrayList<AddressDTO> address) {
		this.address = address;
	}

	public ArrayList<IndexDTO> getIndex() {
		return index;
	}

	public void setIndex(ArrayList<IndexDTO> index) {
		this.index = index;
	}
	

	public ArrayList<ReturnDTO> getReturnDTO() {
		return returnDTO;
	}

	public void setReturnDTO(ArrayList<ReturnDTO> returnDTO) {
		this.returnDTO = returnDTO;
	}

	@Override
	public String toString() {
		return "MatrixAddressDTO [address=" + address + ", index=" + index + ", returnDTO=" + returnDTO + "]";
	}

	
}