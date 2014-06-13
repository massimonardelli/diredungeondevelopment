package org.gradle.diredungeondevelopment.application;

import org.gradle.diredungeondevelopment.model.MappaRepository;

public class IniziaPartitaCommandHandler {

	MappaRepository mappaRepository;
	
	public void handle(IniziaPartitaCommand command){
		mappaRepository.creaNuovaMappa();
	}

	public MappaRepository getMappaRepository() {
		return mappaRepository;
	}

	public void setMappaRepository(MappaRepository mappaRepository) {
		this.mappaRepository = mappaRepository;
	}
	
	
}
