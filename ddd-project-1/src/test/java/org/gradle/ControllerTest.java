package org.gradle;

import java.awt.Point;
import java.util.Map.Entry;

import org.gradle.diredungeondevelopment.application.CaricaPartitaCommand;
import org.gradle.diredungeondevelopment.application.CaricaPartitaCommandHandler;
import org.gradle.diredungeondevelopment.application.Controller;
import org.gradle.diredungeondevelopment.application.CostruisciCasellaCommand;
import org.gradle.diredungeondevelopment.application.CostruisciCasellaCommandHandler;
import org.gradle.diredungeondevelopment.application.IniziaPartitaCommand;
import org.gradle.diredungeondevelopment.application.IniziaPartitaCommandHandler;
import org.gradle.diredungeondevelopment.application.MappaDTO;
import org.gradle.diredungeondevelopment.application.SalvaPartitaCommand;
import org.gradle.diredungeondevelopment.application.SalvaPartitaCommandHandler;
import org.gradle.diredungeondevelopment.application.VediMappaQuery;
import org.gradle.diredungeondevelopment.application.VediMappaQueryHandler;
import org.gradle.diredungeondevelopment.infrastructure.MappaRepositoryImpl;
import org.gradle.diredungeondevelopment.model.MappaRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest {

	final int NUMERO_CASELLE_IN_MAPPA = 9;
	final int NUMERO_CASELLE_PER_LATO = 3;
		
	final int ASCISSA_CASELLA_COSTRUZIONE_1 = 2;
	final int ORDINATA_CASELLA_COSTRUZIONE_1 = 1;
	
	Controller ilController;
	
	@Before
	public void setUp() throws Exception {
		ilController = new Controller();
		MappaRepository mp = new MappaRepositoryImpl();
		IniziaPartitaCommandHandler ipch = new IniziaPartitaCommandHandler();
		ipch.setMappaRepository(mp);
		CostruisciCasellaCommandHandler cch = new CostruisciCasellaCommandHandler();
		cch.setMappaRepository(mp);
		VediMappaQueryHandler vmh = new VediMappaQueryHandler();
		vmh.setMappaRepository(mp);
		
		SalvaPartitaCommandHandler spch = new SalvaPartitaCommandHandler();
		spch.setMappaRepository(mp);
		CaricaPartitaCommandHandler cpch = new CaricaPartitaCommandHandler();
		cpch.setMappaRepository(mp);
		
		ilController.setCostruisciCasellaHandler(cch);
		ilController.setVediMappaHandler(vmh);
		ilController.setIniziaPartitaHandler(ipch);
		ilController.setCaricaPartitaHandler(cpch);
		ilController.setSalvaPartitaHandler(spch);
		
	}

	@Test
	public void testMappaVuota() {
		
		ilController.iniziaPartita(new IniziaPartitaCommand());
		
		VediMappaQuery query1 = new VediMappaQuery();
		MappaDTO mappaDto = ilController.getMappa(query1);
		Assert.assertEquals("La mappa ha più o meno caselle della quantità definita.", NUMERO_CASELLE_IN_MAPPA,mappaDto.getCaselle().keySet().size());
		
		for (Entry<Point, Boolean> entry: mappaDto.getCaselle().entrySet()){
			Assert.assertFalse("Una casella è costruita mentre la mappa doveva essere vuota.",entry.getValue());
		}
	}
	
	@Test
	public void testCostruzione() {
		
		ilController.iniziaPartita(new IniziaPartitaCommand());
		
		CostruisciCasellaCommand ccc = new CostruisciCasellaCommand(ASCISSA_CASELLA_COSTRUZIONE_1, ORDINATA_CASELLA_COSTRUZIONE_1);
		ilController.costruisciCasella(ccc);
		VediMappaQuery query1 = new VediMappaQuery();
		MappaDTO mappaDto = ilController.getMappa(query1);
		
		Assert.assertTrue("La casella non risulta costruita!",mappaDto.getCaselle().get(new Point(ASCISSA_CASELLA_COSTRUZIONE_1, ORDINATA_CASELLA_COSTRUZIONE_1)));
	}
	
	@Test
	public void testSalvaERicarica(){
		//INIZIA PARTITA, COSTRUISCI E SALVA.
		ilController.iniziaPartita(new IniziaPartitaCommand());
		CostruisciCasellaCommand ccc = new CostruisciCasellaCommand(ASCISSA_CASELLA_COSTRUZIONE_1, ORDINATA_CASELLA_COSTRUZIONE_1);
		ilController.costruisciCasella(ccc);
		ilController.salvaPartita(new SalvaPartitaCommand());
		
		//INIZIA UNA NUOVA PARTITA, COSTRUISCI
		ilController.iniziaPartita(new IniziaPartitaCommand());
		VediMappaQuery query1 = new VediMappaQuery();
		MappaDTO mappaDto = ilController.getMappa(query1);
		for (Entry<Point, Boolean> entry: mappaDto.getCaselle().entrySet()){
			Assert.assertFalse("Una casella è costruita mentre la mappa doveva essere vuota.",entry.getValue());
		}
		
		//RICARICA E VERIFICA LO STATO
		ilController.caricaPartita(new CaricaPartitaCommand());
		VediMappaQuery query2 = new VediMappaQuery();
		MappaDTO mappaDto2 = ilController.getMappa(query2);
		Assert.assertTrue("La casella non risulta costruita dopo aver ricaricato!",mappaDto2.getCaselle().get(new Point(ASCISSA_CASELLA_COSTRUZIONE_1, ORDINATA_CASELLA_COSTRUZIONE_1)));
	}
	

}
