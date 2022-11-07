package br.com.calculate.distance.dto;

import java.io.Serializable;
import java.util.Collection;

public class DistanceResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;


	Integer distance;
	Integer time;
	Integer source_index;
	Integer target_index;

	public DistanceResponseDTO() {

	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getSourceIndex() {
		return source_index;
	}

	public void setSource_index(Integer source_index) {
		this.source_index = source_index;
	}

	public Integer getTarget_index() {
		return target_index;
	}

	public void setTarget_index(Integer target_index) {
		this.target_index = target_index;
	}

	@Override
	public String toString() {
		return "DistanceResponse [distance=" + distance + ", time=" + time + ", sourceIndex=" + source_index
				+ ", targetIndex=" + target_index + "]";
	}

	public Collection<String> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	
}