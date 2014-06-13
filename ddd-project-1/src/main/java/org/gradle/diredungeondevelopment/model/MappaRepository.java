package org.gradle.diredungeondevelopment.model;

public interface MappaRepository {
	
	public Mappa mappaDellaPartitaCorrente();
	
	public Mappa mappaDellaPartitaSalvata();
	
	public void caricaMappaSalvata();
	
	public void creaNuovaMappa();
	
	//DDD ma questa è infrastruttura, pagano!
	public void salvaMappaCorrente();
}
