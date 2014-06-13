package org.gradle.diredungeondevelopment.application;

import java.awt.Point;

import org.gradle.diredungeondevelopment.model.Mappa;
import org.gradle.diredungeondevelopment.model.MappaRepository;

public class CostruisciCasellaCommandHandler {

	MappaRepository mappaRepository;
	
	public void handle(CostruisciCasellaCommand command){
		Mappa mappa = mappaRepository.mappaDellaPartitaCorrente();
		Point p = new Point(command.getX(), command.getY());
		mappa.costruisciCasella(p);
	}

	public MappaRepository getMappaRepository() {
		return mappaRepository;
	}

	public void setMappaRepository(MappaRepository mappaRepository) {
		this.mappaRepository = mappaRepository;
	}
	
	
}
