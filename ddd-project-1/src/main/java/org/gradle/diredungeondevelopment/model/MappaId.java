package org.gradle.diredungeondevelopment.model;

public class MappaId {

	private Integer value;

	public MappaId(Integer value) {
		this.value = value;
	}

	public boolean sameValueAs(MappaId aMappaId){
		return aMappaId.value.equals(this.value);
	}
	
	
	
}
