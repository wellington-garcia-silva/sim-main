package io.sim3;

import java.io.IOException;

import de.tudresden.sumo.objects.SumoColor;
import io.sim3.Conta;
//import io.sim3.Route;
import it.polito.appeal.traci.SumoTraciConnection;

import java.util.ArrayList;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.StringEncryptor;

//W classes importadas

public class EnvSimulator extends Thread{//W mudar para Mobility - não mudar!

    private SumoTraciConnection sumo;

	private ArrayList<Rotas> rotasASeremExecutadoas;//Rotas da Company
    private ArrayList<Rotas> rotasEmExecucao;
    private ArrayList<Rotas> rotasExecutadas;
	private Rotas rota;

	private String autoID;//vindos de DRIVINGDATA
	//private String driverID;
	private long timeStamp; 			// System.currentTimeMillis()
	private double x_Position; 			// sumoPosition2D (x)
	private double y_Position; 			// sumoPosition2D (y)
	private String roadIDSUMO; 			// this.sumo.do_job_get(Vehicle.getRoadID(this.idAuto))
	private String routeIDSUMO; 		// this.sumo.do_job_get(Vehicle.getRouteID(this.idAuto))
	private double speed; 				// in m/s for the last time step
	private double odometer; 			// the distance in (m) that was already driven by this vehicle.
	private double fuelConsumption; 	// in mg/s for the last time step
	//private double fuelPrice; 			// price in liters
	//private int fuelType; 				// 1-diesel, 2-gasoline, 3-ethanol, 4-hybrid
	private double averageFuelConsumption;
	//private int personCapacity;			// the total number of persons that can ride in this vehicle
	//private int personNumber;			// the total number of persons which are riding in this vehicle
	private double co2Emission; 		// in mg/s for the last time step
	private double HCEmission; 			// in mg/s for the last time step

	//private Conta conta;

    public EnvSimulator(){
		rotasASeremExecutadoas = new ArrayList<Rotas>();
        rotasEmExecucao = new ArrayList<Rotas>();
        rotasExecutadas = new ArrayList<Rotas>();
    }

    public void run(){
		System.out.println("certo ok");//não precisa
		//String n = "muo";
		//StringEncryptor encryptor = new StandardPBEStringEncryptor();
		//encryptor.setPassword("my-secret-password");
		//String encryptedData = encryptor.encrypt(n);
		//System.out.println(n);//não precisa
		/* SUMO */
		String sumo_bin = "sumo-gui";
		String config_file = "map/map.sumo.cfg";
		
		// Sumo connection
		this.sumo = new SumoTraciConnection(sumo_bin, config_file);
		sumo.addOption("start", "1"); // auto-run on GUI show
		sumo.addOption("quit-on-end", "1"); // auto-close on end

		

		//int numeroDaRota = 0;
		//rotasASeremExecutadoas.add();
		
		
		
		//rota = new Rotas();
		try {
			sumo.runServer(12345);//W: servidor
			for(int i=0;i<900;i++){//adicionando as 900 rotas - É criado 1 rota por vez
				//Rotas rotaAux = new Rotas(i);
				//i=1+1;
				
				
				rota = new Rotas(i);
				//rota.CriaRota(i);
				rotasASeremExecutadoas.add(rota);
				//pegar aqui o id da rota e jogar no itinerário
				rota = rotasASeremExecutadoas.get(i);
				String r = rota.getId();
				rotasEmExecucao.add(rota);

				MobilityCliente m1 = new MobilityCliente();
				BancoServidor b1 = new BancoServidor();
				b1.start();
				m1.start();
				
				//MobilityServidor m2 = new MobilityServidor();
				//m2.iniciarServidor();
				//////b1.IniciaServidorBanco();//Inicia o servidor do banco
				//MobilityServidor m2 = new MobilityServidor(); ?????
				//////m1.IniciaComunicacao();//aqui já faz o pagamneto pela rota

				Itinerary i1 = new Itinerary("map/map.rou.xml", r);// W aqui escolhe qual rota (arquivo, rota)
				
				
				//W: itinerario: significado-> Roteiro de viagem; percurso que se pretende seguir ou que será feito de um local a outro; rota, trajeto, caminho.

				//W: verifica se está ok
				//GerenciadorCheques g = new GerenciadorCheques();
				//g.Arq();
				

				if (i1.isOn()) {

					// fuelType: 1-diesel, 2-gasoline, 3-ethanol, 4-hybrid
					int fuelType = 2; //W tipo de Combustivel
					int fuelPreferential = 2;
					double fuelPrice = 5.87;
					int personCapacity = 5;
					int personNumber = 4;
					SumoColor green = new SumoColor(0, 255, 0, 126);
					System.out.println("certo");
					
					//rotasASeremExecutadoas.add(rota);

					/*CarroCliente c1 = new CarroCliente();//aqui cria o carro cliente
					MobilityCliente m1 = new MobilityCliente();
					DriverCliente driver1 = new DriverCliente();
					FuelStationCliente f1 = new FuelStationCliente();

					String car = c1.RetornaCar(i);
					String driver = driver1.RetornaDriver(i);*/

					Carro carro = new Carro();
					String carr = carro.RetornaCar(i);

					CarroTest ct = new CarroTest();
					ct.RetornaCar(1);//Teste Unitario

					Driver driver = new Driver();
					String dri = driver.RetornaDriver(i);

					System.out.println(dri);
					System.out.println(carr );

					Auto a1 = new Auto(true, carr, green,dri, sumo, 500, fuelType, fuelPreferential, fuelPrice, personCapacity, personNumber); //W aqui tem os carros e os motoristas

					timeStamp=a1.getTimeStamp();
					autoID=a1.getIdAuto();
					routeIDSUMO=a1.getRoadIDSUMO();
					speed=a1.getSpeed();
					fuelConsumption=a1.getFuelConsumption();
					fuelType=a1.getFuelType();
					co2Emission=a1.getCo2Emission();
					x_Position=a1.getX_Position();
					y_Position=a1.getX_Position();

					MobilityServidor mobilityServidor = new MobilityServidor();
					CarroCliente carroCliente = new CarroCliente(timeStamp,autoID,routeIDSUMO,speed,fuelConsumption,fuelType,co2Emission,x_Position,y_Position);

					mobilityServidor.start();
					carroCliente.start();

					/*MobilityServidor mobilityServidor = new MobilityServidor();
					CarroCliente carroCliente = new CarroCliente(timeStamp,autoID,routeIDSUMO,speed,fuelConsumption,fuelType,co2Emission,x_Position,y_Position);
					mobilityServidor.iniciarServidor();
					carroCliente.IniciaCarro();


					DriverCliente driverCliente = new DriverCliente();
					driverCliente.IniciaDriver();

					//FuelStationCliente fuelStationCliente = new FuelStationCliente();*/
 

					//--------------------- Aqui onde são feitos os pagamentos
					//MobilityServidor m2 = new MobilityServidor();
					
					//MobilityCliente m1 = new MobilityCliente();

					//m2.iniciarServidor();
					//m1.IniciaComunicacao();
					
					//CarroCliente c1 = new CarroCliente();//aqui cria o carro cliente
					/////Poderia por exemplo pegar informações de Auto e passa para o Carro por meio de método ex: passaParaCarro(get.PersonCapacity(), getFuelPrice() )
					
					//BancoServidor b1 = new BancoServidor();
					//b1.IniciaServidorBanco();
					//DriverCliente driver1 = new DriverCliente();
					//driver1.IniciaDriver();
					//FuelStationCliente f1 = new FuelStationCliente();
					//f1.IniciaFuelStation();

					TransportService tS1 = new TransportService(true, carr, i1, a1, sumo);//W: aqui chama TransportService: carro, rota, sumo
					//W: no lugar de car, estava "CAR1"

					DriverCliente driverCliente= new DriverCliente();
					FuelStationCliente fuelStationCliente = new FuelStationCliente();
					driverCliente.start();
					fuelStationCliente.start();

					
					System.out.println(a1.getIdAuto());
					
					tS1.start();

					Thread.sleep(5000);

					a1.start();

					//Excel e1 = new Excel();
					//e1.Arq();
					
					try {
						tS1.join();
						a1.join();
					} catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}

					//Aqui passar os dados do carro para  o Excel

					rota = rotasEmExecucao.get(i);
					rotasExecutadas.add(rota);

					//aqui fazer as tranferencias
					//a1.join(personCapacity, personNumber);
					//tS1.join();
					//Itinerary i2 = new Itinerary("map.rou.xml", "1");
					//Fazer outro if para outra rota: criar outro objeto
					

			}
			

			//Ao final fazer os joins
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
