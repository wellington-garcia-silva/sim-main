package io.sim4;

import java.io.IOException;

import de.tudresden.sumo.objects.SumoColor;
import io.sim.DrivingData;
//import io.sim3.Conta;
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
	private double timeStamp; 			// System.currentTimeMillis()
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

	///////////////Segunda Parte////////////
	private double tempoInicial;//long
	private double tempoFinal;
	private double velocidadeInicial;
	private double velocidadeFinal;

	private double velocidadeP1;
	private double velocidadeP2;
	private double velocidadeP3;
	private double velocidadeP4;
	private double velocidadeP5;
	private double velocidadeP6;

	private double tempoP1;
	private double tempoP2;
	private double tempoP3;
	private double tempoP4;
	private double tempoP5;
	private double tempoP6;

	private long converter;

	private boolean t;




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
				//for(int i=0;i<900;i++){//adicionando as 900 rotas - É criado 1 rota por vez // For apagado desta vez
					//Rotas rotaAux = new Rotas(i);
					//i=1+1;
				
				
				rota = new Rotas(0);//era i
				//rota.CriaRota(i);
				rotasASeremExecutadoas.add(rota);
				//pegar aqui o id da rota e jogar no itinerário
				rota = rotasASeremExecutadoas.get(0);//era i
				String r = rota.getId();
				rotasEmExecucao.add(rota);

				//MobilityCliente m1 = new MobilityCliente();
				//BancoServidor b1 = new BancoServidor();
				//b1.start();
				//m1.start();
				
				//MobilityServidor m2 = new MobilityServidor();
				//m2.iniciarServidor();
				//////b1.IniciaServidorBanco();//Inicia o servidor do banco
				//MobilityServidor m2 = new MobilityServidor(); ?????
				//////m1.IniciaComunicacao();//aqui já faz o pagamneto pela rota

				Itinerary i1 = new Itinerary("map/map.rou.xml", "0",0);// W aqui escolhe qual rota (arquivo, rota) // antes era r


				
				
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
					String carr1 = carro.RetornaCar(0);//era i
					String carr2 = carro.RetornaCar(2);//era i
					String carr3 = carro.RetornaCar(3);//era i

					CarroTest ct = new CarroTest();
					ct.RetornaCar(58);//Teste Unitario

					Driver driver = new Driver();
					String dri = driver.RetornaDriver(0);//era i

					System.out.println(dri);
					System.out.println(carr1 );

					Auto a1 = new Auto(true, carr1, green,dri, sumo, 500, fuelType, fuelPreferential, fuelPrice, personCapacity, personNumber); //W aqui tem os carros e os motoristas

					Auto a2 = new Auto(true, carr2, green,dri, sumo, 500, fuelType, fuelPreferential, fuelPrice, personCapacity, personNumber); //W aqui tem os carros e os motoristas

					Auto a3 = new Auto(true, carr3, green,dri, sumo, 500, fuelType, fuelPreferential, fuelPrice, personCapacity, personNumber); //W aqui tem os carros e os motoristas

					

					//public void updateSheetCar(DrivingData data, String nomeDoArquivo, String nomeDaAba) {

			//String _autoID, String _driverID, long _timeStamp, double _x_Position, double _y_Position,
			//String _roadIDSUMO, String _routeIDSUMO, double _speed, double _odometer, double _fuelConsumption,
			//double _averageFuelConsumption, int _fuelType, double _fuelPrice, double _co2Emission, double _HCEmission, int _personCapacity, int _personNumber)

					//DrivingData dd = new DrivingData("k","k",1,3,3,"n","n",4,4,5,4,4,6,7,8,4,4);
					//a1.Criar();
					//c.updateSheetCar(dd,"exemplo1.xlsx","nome");
					
					//a1.Criar();

					
					//converter=
					timeStamp=a1.getTimeStamp();
					autoID=a1.getIdAuto();
					routeIDSUMO=a1.getRoadIDSUMO();
					speed=a1.getSpeed();
					fuelConsumption=a1.getFuelConsumption();
					fuelType=a1.getFuelType();
					co2Emission=a1.getCo2Emission();
					x_Position=a1.getX_Position();
					y_Position=a1.getX_Position();
					
					

					

					/*MobilityServidor mobilityServidor = new MobilityServidor();
					CarroCliente carroCliente = new CarroCliente(timeStamp,autoID,routeIDSUMO,speed,fuelConsumption,fuelType,co2Emission,x_Position,y_Position);

					mobilityServidor.start();
					carroCliente.start();

					///////////????????????//////////////

					MobilityServidor mobilityServidor = new MobilityServidor();
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

					TransportService tS1 = new TransportService(true, carr1, i1, a1, sumo);//W: aqui chama TransportService: carro, rota, sumo
					TransportService tS2 = new TransportService(true, carr2, i1, a2, sumo);//W: aqui chama 
					TransportService tS3 = new TransportService(true, carr3, i1, a3, sumo);//W: aqui chama 
					//W: no lugar de car, estava "CAR1"

					

					

					//DriverCliente driverCliente= new DriverCliente();
					//FuelStationCliente fuelStationCliente = new FuelStationCliente();
					//driverCliente.start();
					//fuelStationCliente.start();

					
					System.out.println(a1.getIdAuto());
					
					tS1.start();

					CriarPlanilhaExcel c = new CriarPlanilhaExcel();
					c.createSheet("nome");
					c.adicionarAba("exemplo.xlsx", "nome1");
					c.updateSheetCar(a1.Criar(),"exemplo.xlsx","nome");

					while(t){
						//routeIDSUMO --> routeIDSUMO !="-14479140"
						//sumo.isClosed();
						
						//if(a1.getRoadIDSUMO().equals("341671964#0")){
						//if(i1.ponto().equals("341671964#0"))
						//tempoInicial=a1.getTimeStamp();
						//speed=a1.getSpeed();

						//" 341671964#4 341671964#5  341671964#7 341671964#8  341671964#10 341671964#11  794061367#0 794061367#1   794061367#3 794061367#4   794061352#0 794061352#1    795084570#1 795084570#2    795084570#4 795084570#5 795084569#0 795084569#1 795084569#2 795084569#3 15469789#0 15469789#1 15469789#2 15469789#3 15469789#4 15469789#5 15469789#6 15469789#7 795084568 392002072#0 392002072#1 392002072#2 14479140 -14479140"/>

						// 
						
				

						//if(i1.getIdItinerary().equals("341671964#10")){
						if(a1.getIdRota().equals("341671964#3")){//341671964#3
							
							converter=a1.getTimeStamp();
							//tempoInicial=a1.getTimeStamp();
							tempoInicial=(double)converter;
							velocidadeInicial=a1.getSpeed();

						}
						//if(a1.getRoadIDSUMO().equals("341671964#10")){
						//if(i1.ponto().equals("341671964#10")){
						//if(i1.getIdItinerary().equals("341671964#10")){ getIdRota()
						if(a1.getIdRota().equals("341671964#4")){//341671964#10

							
							converter=a1.getTimeStamp();
							tempoP1=(double)converter;
							velocidadeP1=a1.getSpeed();
							tempoP1=tempoP1-tempoInicial;
						}

						//if(a1.getRoadIDSUMO().equals("794061352#0")){
						//if(i1.ponto().equals("794061352#0")){
						//if(i1.getIdItinerary().equals("794061352#0")){

							
						if(a1.getIdRota().equals("341671964#5")){//794061367#3
							converter=a1.getTimeStamp();
							tempoP2=(double)converter;
							velocidadeP2=a1.getSpeed();
							tempoP2=tempoP2-tempoP1;
						}

						//if(a1.getRoadIDSUMO().equals("795084569#1")){
						//if(i1.ponto().equals("795084569#1")){
						//if(i1.getIdItinerary().equals("795084569#1")){
						if(a1.getIdRota().equals("341671964#6")){//795084570#0
							converter=a1.getTimeStamp();
							tempoP3=(double)converter;
							velocidadeP3=a1.getSpeed();
							tempoP3=tempoP3-tempoP2;
						}

						//if(a1.getRoadIDSUMO().equals("15469789#7")){
						//if(i1.ponto().equals("15469789#7")){
						//if(i1.getItinerary().equals("15469789#7")){

							
						if(a1.getIdRota().equals("341671964#7 ")){//795084569#1
							converter=a1.getTimeStamp();
							tempoP4=a1.getTimeStamp();
							velocidadeP4=a1.getSpeed();
							tempoP4=tempoP4-tempoP3;
							
						}
						
						
						//if(a1.getRoadIDSUMO().equals("15469789#7")){
						//if(i1.ponto().equals("15469789#7")){
						//if(i1.getItinerary().equals("15469789#7")){
						if(a1.getIdRota().equals("341671964#8")){//15469789#0
							converter=a1.getTimeStamp();
							tempoP5=(double)converter;
							velocidadeP5=a1.getSpeed();
							tempoP5=tempoP5-tempoP4;
							
						//if(a1.getRoadIDSUMO().equals("15469789#7")){
						//if(i1.ponto().equals("15469789#7")){
						//if(i1.getItinerary().equals("15469789#7")){
							//     
						}
						if(a1.getIdRota().equals("341671964#9")){//15469789#7
							converter=a1.getTimeStamp();
							tempoP6=(double)converter;
							velocidadeP6=a1.getSpeed();
							tempoP6=tempoP6-tempoP5;

						}
						
						//if(a1.getRoadIDSUMO().equals("-14479140")){
						//if(i1.getItinerary().equals("-14479140")){
						if(a1.getIdRota().equals("341671964#3")){//  -14479140 341671964#3 341671964#10
							converter=a1.getTimeStamp();
							tempoFinal=(double)converter;
							velocidadeFinal=a1.getSpeed();
							tempoFinal=tempoFinal-tempoInicial;
							t = false;
						}
						
						tempoP6=5;
						tempoP5=5;
						velocidadeP5=5;
						velocidadeP6=5;
					}
					//c.updateSheetCar(timeStamp,autoID,routeIDSUMO,speed,fuelConsumption,fuelType,co2Emission,x_Position,y_Position, tempoInicial,tempoFinal,velocidadeInicial,velocidadeFinal, velocidadeP1,  velocidadeP2,  velocidadeP3,  velocidadeP4,  velocidadeP5,  velocidadeP6,  tempoP1, tempoP2,  tempoP3,  tempoP4,  tempoP5,  tempoP6,"exemplo1.xlsx","nome");
					

					//GerarRelatorioAV relatorio = new GerarRelatorioAV(timeStamp,autoID,routeIDSUMO,speed,fuelConsumption,fuelType,co2Emission,x_Position,y_Position, tempoInicial,tempoFinal,velocidadeInicial,velocidadeFinal, velolsxcidadeP1,  velocidadeP2,  velocidadeP3,  velocidadeP4,  velocidadeP5,  velocidadeP6,  tempoP1, tempoP2,  tempoP3,  tempoP4,  tempoP5,  tempoP6);
            		//relatorio.start();//

					Thread.sleep(5000);

					

					a1.start();

					///////////////////Segunda Parte/////////////////////////////////////
					//posso usar um while para saber quando todas as informações foram adquiridas
					//posso dar um sleep até adquirir todas as informações
					//while(a1.getRoadIDSUMO().equals("341671964#0"){

					routeIDSUMO = a1.getRoadIDSUMO();
					
					//}
					//String edge= i1.getBaa();
					//String ponto = i1.ponto();
					t = true;
					
					
					
					
					

					////////////////////Segunda Parte///////////////////////////////////

					//Excel e1 = new Excel();
					//e1.Arq();

					//GerarRelatorioAv2 g2 = new GerarRelatorioAv2(dri, null, null, null, null, null, null, fuelType);

					

					//if(a1.getRoadIDSUMO().equals("-14479140")){//era while
						//criar o objeto com todas as informçãoes já adquiridas
						//GerarRelatorioAv2 g3 = new GerarRelatorioAv2(dri, null, null, null, null, null, null, fuelType);
						//
						//GerarRelatorioAv2 g3 = new GerarRelatorioAv2(dri, null, null, null, null, null, null, fuelType);
						//outros dados a serem adicionados: tempo GerarRelatorioAv2(dri, null, null, null, null, null, null, fuelType, tempoInicial, tempoFinal, velocidadeInicial, velocidadeFinal, tempo1, tempo2,tempo3,tempo4,tempo5, velocidade1, velociade2, velocidade3, velocide4, velociade5);
						
						
					//}
					
					//GerarRelatorioAV g4 = new GerarRelatorioAV(autoID,tempoInicial,speed,fuelConsumption,co2Emission,x_Position,y_Position,fuelType);

					
					//Aqui passar os dados do carro para  o Excel

					rota = rotasEmExecucao.get(0);//era i
					rotasExecutadas.add(rota);

					//aqui fazer as tranferencias
					//a1.join(personCapacity, personNumber);
					//tS1.join();
					//Itinerary i2 = new Itinerary("map.rou.xml", "1");
					//Fazer outro if para outra rota: criar outro objeto
					
					//}try {
						//tS1.join();
						//a1.join();
					//} catch (InterruptedException e) {
						// TODO: handle exception
						//e.printStackTrace();
					//}

					
					

			//}
			

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
