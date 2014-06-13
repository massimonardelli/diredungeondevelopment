package org.gradle.diredungeondevelopment.infrastructure;



import org.gradle.diredungeondevelopment.model.Mappa;
import org.gradle.diredungeondevelopment.model.MappaId;
import org.gradle.diredungeondevelopment.model.MappaRepository;

public class MappaRepositoryImpl implements MappaRepository{

	private Mappa mappaCorrente;
	private Mappa mappaSalvata;
	
	private int nextId = 0;
	
	public Mappa mappaDellaPartitaCorrente() {
		return mappaCorrente;
	}

	public Mappa mappaDellaPartitaSalvata() {
		return mappaSalvata;
	}

	public void creaNuovaMappa() {
		mappaCorrente = Mappa.creaNuovaMappa(new MappaId(nextId++));
	}

	public void salvaMappaCorrente() {
		mappaSalvata = mappaCorrente;
	}

	public void caricaMappaSalvata() {
		mappaCorrente = mappaSalvata;
	}
	

}
