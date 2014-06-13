package org.gradle.diredungeondevelopment.model;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 * Aggregate Mappa
 * 
 * @author max
 *
 */
public class Mappa {
	
	private MappaId mappaId;
	private HashMap<Point, Boolean> caselle;
	
	public static Mappa creaNuovaMappa(MappaId aMappaId){
		if (aMappaId == null) throw new IllegalArgumentException("L'id di una nuova mappa non può essere nullo");
		
		HashMap<Point, Boolean> caselle = new HashMap<Point, Boolean>();
		for (int x = 0; x < 3; x++){
			for (int y = 0; y< 3; y++){
				caselle.put(new Point(x,y), Boolean.FALSE);
			}
		}
		Mappa newMappa = new Mappa();
		newMappa.caselle = caselle;
		newMappa.mappaId = aMappaId;
		return newMappa;
	}
	
	//DDD costruttore privato per la creazione
	private Mappa(){}
	
	//DDD ritorno una copia, anche se modificabile. O è meglio una versione immutabile? O una semplice itnerfaccia solo get?
	public Map<Point, Boolean> getCaselle(){
		Map<Point, Boolean> caselleCopy = new HashMap<Point, Boolean>();
		for (Point p : caselle.keySet()){
			caselleCopy.put((Point)p.clone(), Boolean.valueOf(caselle.get(p).booleanValue()));
		}
		return caselleCopy;
	}
	
	public void costruisciCasella(Point aPoint){
		if (aPoint == null) throw new IllegalArgumentException("E' necessario specificare un punto dove costruire");
		if (! caselle.containsKey(aPoint)) throw new IllegalArgumentException("E' necessario specificare un punto presente nella mappa");
		if (costruito(aPoint)) throw new IllegalArgumentException("La casella scelta è già costruita");
		
		caselle.put(aPoint, Boolean.TRUE);
	}
	
	public MappaId identity() {
		return mappaId;
	}

	private boolean costruito(Point aPoint){
		return caselle.get(aPoint);
	}
	
}
