package io.sim;

import java.io.IOException;

import de.tudresden.sumo.objects.SumoColor;
import it.polito.appeal.traci.SumoTraciConnection;

//W classes importadas

public class EnvSimulator extends Thread{//W mudar para Mobility

    private SumoTraciConnection sumo;

    public EnvSimulator(){

    }

    public void run(){

		/* SUMO */
		String sumo_bin = "sumo-gui";
		String config_file = "SIM-MAIN/map/map.sumo.cfg";
		
		// Sumo connection
		this.sumo = new SumoTraciConnection(sumo_bin, config_file);
		sumo.addOption("start", "1"); // auto-run on GUI show
		sumo.addOption("quit-on-end", "1"); // auto-close on end


		try {
			sumo.runServer(12345);//W: servidor
			
			//data/dados2.xml
			Itinerary i1 = new Itinerary("dada/dados2.xml", "0");// W aqui escolhe qual rota (arquivo, rota)
			//W: itinerario: significado-> Roteiro de viagem; percurso que se pretende seguir ou que será feito de um local a outro; rota, trajeto, caminho.
			//W: verifica se está ok
			//i1.getIDItinerary();
			

			if (i1.isOn()) {

				// fuelType: 1-diesel, 2-gasoline, 3-ethanol, 4-hybrid
				int fuelType = 2; //W tipo de Combustivel
				int fuelPreferential = 2;
				double fuelPrice = 3.40;
				int personCapacity = 1;
				int personNumber = 1;
				SumoColor green = new SumoColor(0, 255, 0, 126);

				Auto a1 = new Auto(true, "CAR1", green,"D1", sumo, 500, fuelType, fuelPreferential, fuelPrice, personCapacity, personNumber); //W aqui tem os carros e os motoristas

				TransportService tS1 = new TransportService(true, "CAR1", i1, a1, sumo);//W: aqui chama TransportService: carro, rota, sumo

				tS1.start();
                Thread.sleep(5000);
				a1.start();

			}

		
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

    }

}
