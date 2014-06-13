package org.gradle.diredungeondevelopment.application;

import java.awt.Point;
import java.util.Map;

import org.gradle.diredungeondevelopment.model.Mappa;

public class MappaDTO {

	private Map<Point, Boolean> caselle;
	
	public MappaDTO(Mappa unaMappa) {
		super();
		//DDD e se la mappa è nulla in quanto non c'è nessuna partita avviata o salvata? Qui scoppia ma non mi sembra il punto giusto. Che non ci sia la partita è un'informazione di dominio.
		this.caselle = unaMappa.getCaselle();
	}

	public Map<Point, Boolean> getCaselle() {
		return caselle;
	}

	public void setCaselle(Map<Point, Boolean> caselle) {
		this.caselle = caselle;
	}

	
	
}
