package org.gradle.diredungeondevelopment.application;

import org.gradle.diredungeondevelopment.infrastructure.MappaRepositoryImpl;
import org.gradle.diredungeondevelopment.model.MappaRepository;

public class Controller {

	CostruisciCasellaCommandHandler costruisciCasellaHandler;
	VediMappaQueryHandler vediMappaHandler;
	IniziaPartitaCommandHandler iniziaPartitaHandler;
	SalvaPartitaCommandHandler salvaPartitaHandler;
	CaricaPartitaCommandHandler caricaPartitaHandler;
	
	public MappaDTO getMappa(VediMappaQuery query){
		MappaDTO mappaDto = vediMappaHandler.handle(query);
		return mappaDto;
	}
	
	public void costruisciCasella(CostruisciCasellaCommand command){
		costruisciCasellaHandler.handle(command);
	}
	
	public void iniziaPartita(IniziaPartitaCommand command){
		iniziaPartitaHandler.handle(command);
	}
	
	public void salvaPartita(SalvaPartitaCommand command) {
		salvaPartitaHandler.handle(command);
	}

	public void caricaPartita(CaricaPartitaCommand command) {
		caricaPartitaHandler.handle(command);
	}
	
	
	public static void main(String[] args) {
		
		Controller controller = new Controller();
		MappaRepository mp = new MappaRepositoryImpl();
		CostruisciCasellaCommandHandler cch = new CostruisciCasellaCommandHandler();
		cch.setMappaRepository(mp);
		VediMappaQueryHandler vmh = new VediMappaQueryHandler();
		vmh.setMappaRepository(mp);
		controller.setCostruisciCasellaHandler(cch);
		controller.setVediMappaHandler(vmh);
		
		
/*		Scanner scan = new Scanner(System.in);
		boolean inGame = true;
		
		while(inGame){
			System.out.println("i: inizia partita \t m: mostra mappa \t c <x> <y>: costruisci \t t: termina");
			String line = scan.nextLine().trim();
			String [] parts = line.split(" ");
			
		}*/
		
	}
	
	
	public CostruisciCasellaCommandHandler getCostruisciCasellaHandler() {
		return costruisciCasellaHandler;
	}

	public void setCostruisciCasellaHandler(
			CostruisciCasellaCommandHandler costruisciCasellaHandler) {
		this.costruisciCasellaHandler = costruisciCasellaHandler;
	}

	public VediMappaQueryHandler getVediMappaHandler() {
		return vediMappaHandler;
	}

	public void setVediMappaHandler(VediMappaQueryHandler vediMappaHandler) {
		this.vediMappaHandler = vediMappaHandler;
	}

	public IniziaPartitaCommandHandler getIniziaPartitaHandler() {
		return iniziaPartitaHandler;
	}

	public void setIniziaPartitaHandler(
			IniziaPartitaCommandHandler iniziaPartitaHandler) {
		this.iniziaPartitaHandler = iniziaPartitaHandler;
	}

	public SalvaPartitaCommandHandler getSalvaPartitaHandler() {
		return salvaPartitaHandler;
	}

	public void setSalvaPartitaHandler(
			SalvaPartitaCommandHandler salvaPartitaHandler) {
		this.salvaPartitaHandler = salvaPartitaHandler;
	}

	public CaricaPartitaCommandHandler getCaricaPartitaHandler() {
		return caricaPartitaHandler;
	}

	public void setCaricaPartitaHandler(
			CaricaPartitaCommandHandler caricaPartitaHandler) {
		this.caricaPartitaHandler = caricaPartitaHandler;
	}


	
	
	
	
}


