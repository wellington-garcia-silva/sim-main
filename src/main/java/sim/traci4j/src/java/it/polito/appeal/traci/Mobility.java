
/*package sim.traci4j.src.java.it.polito.appeal.traci;
import java.util.ArrayList;

public class Mobility extends Thread {

    private ArrayList<Route> rotasExecutadas = new ArrayList<Route>();
    private ArrayList<Route> rotasASeremExecutadas = new ArrayList<Route>();
    private ArrayList<Route> rotasEmExecucao = new ArrayList<Route>();

    public Mobility(){
        Route r = new Route(null, null, getName(), null);
        rotasExecutadas.add(r);
    }

    public void run() {
        // Código que será executado na thread
        System.out.println("Esta é a minha thread!");
    }

    public static void main(String[] args) {
        // Cria uma instância da sua thread personalizada
        Mobility minhaThread = new Mobility();

        // Inicia a thread
        minhaThread.start();
    }
}
public class ClasseExterna {
    // Classe interna estática
    static class ClasseInterna {
        void imprimirMensagem() {
            System.out.println("Isso é da classe interna estática.");
        }
    }
    
    public static void main(String[] args) {
        // Instanciando a classe interna estática
        ClasseInterna interna = new ClasseInterna();
        interna.imprimirMensagem();
    }
} 
 package io.sim;

import java.io.IOException;

import de.tudresden.sumo.objects.SumoColor;
import it.polito.appeal.traci.SumoTraciConnection;

//W classes importadas

public class EnvSimulator extends Thread{

    private SumoTraciConnection sumo;

    public EnvSimulator(){

    }

    public void run(){

		
		String sumo_bin = "sumo-gui";
		String config_file = "map/map.sumo.cfg";
		
		// Sumo connection
		this.sumo = new SumoTraciConnection(sumo_bin, config_file);
		sumo.addOption("start", "1"); // auto-run on GUI show
		sumo.addOption("quit-on-end", "1"); // auto-close on end

		try {
			sumo.runServer(12345);//W: servidor

			Itinerary i1 = new Itinerary("data/dados2.xml", "0");// W aqui escolhe qual rota (arquivo, rota)
			//W: itinerario: significado-> Roteiro de viagem; percurso que se pretende seguir ou que será feito de um local a outro; rota, trajeto, caminho.
			//W: verifica se está ok

			if (i1.isOn()) {

				// fuelType: 1-diesel, 2-gasoline, 3-ethanol, 4-hybrid
				int fuelType = 2; //W tipo de Combustivel
				int fuelPreferential = 2;
				double fuelPrice = 3.40;
				int personCapacity = 1;
				int personNumber = 1;
				SumoColor green = new SumoColor(0, 255, 0, 126);
				Auto a1 = new Auto(true, "CAR1", green,"D1", sumo, 500, fuelType, fuelPreferential, fuelPrice, personCapacity, personNumber);
				TransportService tS1 = new TransportService(true, "CAR1", i1, a1, sumo);//W: aqui chama TransportService
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
*/

