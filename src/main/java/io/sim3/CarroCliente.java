package io.sim3;

//import java.io.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class CarroCliente extends Thread{//carro
    private double tank;
    private String route;

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
    private int fuelType;
    
    CarroCliente(long _timeStamp,String _autoID,String _routeIDSUMO,double _speed,double _fuelConsumption,int _fuelType,double _co2Emission,double _x_Position,double _y_Position){ // esta classe apenas troca informações com a Mobility
        //InetAddress enderecoIP = InetAddress.getLocalHost();
        timeStamp=_timeStamp;
        autoID=_autoID;
        routeIDSUMO=_routeIDSUMO;
        speed=_speed;
        fuelConsumption=_fuelConsumption;
        co2Emission=_co2Emission;
        x_Position=_x_Position;
        y_Position=_y_Position;
        fuelType = _fuelType;

    }
    //public void IniciaCarro(){
    public void run(){
        try{
            Socket socket = new Socket("localhost",4500);//"192.168.0.107"
            DataOutputStream saida = new DataOutputStream(socket.getOutputStream());//manda informação do carro
            saida.writeLong(timeStamp);
            saida.writeUTF(autoID);
            saida.writeDouble(speed);
            saida.writeDouble(fuelConsumption);
            saida.writeDouble(co2Emission);
            saida.writeDouble(x_Position);
            saida.writeDouble(y_Position);
            saida.writeInt(fuelType);
            // saida.writeDouble(odometer);
            //saida.writeDouble(speed);
            //saida.writeDouble(averageFuelConsumption);
            
            //saida.writeDouble(HCEmission);
            
            System.out.println("cliente ok");
            
            //DataInputStream entrada = new DataInputStream(socket.getInputStream());////
            //String novaMensagem = entrada.readUTF();
            //System.out.println(novaMensagem);
            //System.out.println("Cliente mmm" );
            //Auto a1 = new Auto(false, novaMensagem, null, novaMensagem, null, 0, 0, 0, 0, 0, 0);
            //daqui criar o relatório;

            //entrada.close();
            saida.close();

            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //public static void main(String[] args )throws IOException {
        //ServerSocket servidorSocket = new ServerSocket(54321, 0, null);
        
        
    //}
    public String RetornaCar(int i){
        //i = i + 7;
        String car = Integer.toString(i);
        car = "CAR" + car;
        return car;
    }
}

