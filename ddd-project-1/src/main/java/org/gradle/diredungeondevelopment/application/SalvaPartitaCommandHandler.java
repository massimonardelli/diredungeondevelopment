package org.gradle.diredungeondevelopment.application;

import org.gradle.diredungeondevelopment.model.MappaRepository;

public class SalvaPartitaCommandHandler {

	MappaRepository mappaRepository;
	
	public void handle(SalvaPartitaCommand command) {
		mappaRepository.salvaMappaCorrente();
		
	}

	public MappaRepository getMappaRepository() {
		return mappaRepository;
	}

	public void setMappaRepository(MappaRepository mappaRepository) {
		this.mappaRepository = mappaRepository;
	}
	
	

}
