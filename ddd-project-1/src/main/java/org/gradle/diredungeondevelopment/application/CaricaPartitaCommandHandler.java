package org.gradle.diredungeondevelopment.application;

import org.gradle.diredungeondevelopment.model.MappaRepository;

public class CaricaPartitaCommandHandler {
	
	MappaRepository mappaRepository;
	
	public void handle(CaricaPartitaCommand command) {
		mappaRepository.caricaMappaSalvata();
	}

	public MappaRepository getMappaRepository() {
		return mappaRepository;
	}

	public void setMappaRepository(MappaRepository mappaRepository) {
		this.mappaRepository = mappaRepository;
	}

	
}
