package org.gradle.diredungeondevelopment.application;

import org.gradle.diredungeondevelopment.model.MappaRepository;

public class VediMappaQueryHandler {

	MappaRepository mappaRepository;
	
	public MappaDTO handle(VediMappaQuery query){
		MappaDTO dto = new MappaDTO(mappaRepository.mappaDellaPartitaCorrente());
		return dto;
	}

	public MappaRepository getMappaRepository() {
		return mappaRepository;
	}

	public void setMappaRepository(MappaRepository mappaRepository) {
		this.mappaRepository = mappaRepository;
	}
	
	
	
}
