package br.com.calculate.distance.dto;

import java.io.Serializable;

public class RankDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	float importance;
	float popularity;
	float confidence;
	float confidence_city_level;
	float confidence_street_level;
	String match_type;

	// Getter Methods

	public float getImportance() {
		return importance;
	}

	public float getPopularity() {
		return popularity;
	}

	public float getConfidence() {
		return confidence;
	}

	public float getConfidence_city_level() {
		return confidence_city_level;
	}

	public float getConfidence_street_level() {
		return confidence_street_level;
	}

	public String getMatch_type() {
		return match_type;
	}

	// Setter Methods

	public void setImportance(float importance) {
		this.importance = importance;
	}

	public void setPopularity(float popularity) {
		this.popularity = popularity;
	}

	public void setConfidence(float confidence) {
		this.confidence = confidence;
	}

	public void setConfidence_city_level(float confidence_city_level) {
		this.confidence_city_level = confidence_city_level;
	}

	public void setConfidence_street_level(float confidence_street_level) {
		this.confidence_street_level = confidence_street_level;
	}

	public void setMatch_type(String match_type) {
		this.match_type = match_type;
	}

	@Override
	public String toString() {
		return "Rank [importance=" + importance + ", popularity=" + popularity + ", confidence=" + confidence
				+ ", confidence_city_level=" + confidence_city_level + ", confidence_street_level="
				+ confidence_street_level + ", match_type=" + match_type + "]";
	}

}