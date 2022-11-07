package br.com.calculate.distance.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class MatrixDTO implements Serializable {

	private static final long serialVersionUID = 1L;

    String mode;
	ArrayList<SourcesDTO> sources = new ArrayList<SourcesDTO>();
	ArrayList<TargetsDTO> targets = new ArrayList<TargetsDTO>();
	
	public MatrixDTO() {
		
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public ArrayList<SourcesDTO> getSources() {
		return sources;
	}
	public void setSources(ArrayList<SourcesDTO> sources) {
		this.sources = sources;
	}
	public ArrayList<TargetsDTO> getTargets() {
		return targets;
	}
	public void setTargets(ArrayList<TargetsDTO> targets) {
		this.targets = targets;
	}
	@Override
	public String toString() {
		return "MatrixDTO [mode=" + mode + ", sources=" + sources + ", targets=" + targets + "]";
	}

	
}