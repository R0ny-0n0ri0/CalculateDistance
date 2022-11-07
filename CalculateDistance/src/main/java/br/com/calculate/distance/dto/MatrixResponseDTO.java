package br.com.calculate.distance.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class MatrixResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	ArrayList<SourcesResponseDTO> sources = new ArrayList<SourcesResponseDTO>();
	ArrayList<TargetsResponseDTO> targets = new ArrayList<TargetsResponseDTO>();
	ArrayList<DistanceResponseDTO[]> sources_to_targets = new ArrayList<DistanceResponseDTO[]>();
	String units;
	String distance_units;
	String mode;
	
	public MatrixResponseDTO() {
		
	}

	public ArrayList<SourcesResponseDTO> getSources() {
		return sources;
	}

	public void setSources(ArrayList<SourcesResponseDTO> sources) {
		this.sources = sources;
	}


	public ArrayList<TargetsResponseDTO> getTargets() {
		return targets;
	}

	public void setTargets(ArrayList<TargetsResponseDTO> targets) {
		this.targets = targets;
	}

	public ArrayList<DistanceResponseDTO[]> getSources_to_targets() {
		return sources_to_targets;
	}

	public void setSources_to_targets(ArrayList<DistanceResponseDTO[]> sources_to_targets) {
		this.sources_to_targets = sources_to_targets;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getDistance_units() {
		return distance_units;
	}

	public void setDistanceUnits(String distance_units) {
		this.distance_units = distance_units;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public String toString() {
		return "MatrixResponseDTO [sources=" + sources + ", targets=" + targets + ", sources_to_targets=" + sources_to_targets
				+ ", units=" + units + ", distanceUnits=" + distance_units + ", mode=" + mode + "]";
	}
	
}