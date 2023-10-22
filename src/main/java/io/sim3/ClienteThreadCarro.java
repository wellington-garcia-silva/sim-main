package io.sim3;


import java.io.DataOutputStream;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
//import java.net.ServerSocket;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class ClienteThreadCarro extends Thread{
    private Socket socket;
    public ClienteThreadCarro(Socket s){
        this.socket = s;
    }
    public void run(){
        System.out.println(Thread.currentThread().getName());
        try{
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            String autoID = entrada.readUTF();
            Long timeStamp = entrada.readLong();
            Double speed = entrada.readDouble();
            Double fuelConsumption = entrada.readDouble();
            Double co2Emission = entrada.readDouble();
            Double x_Position = entrada.readDouble();
            Double y_Position = entrada.readDouble();
            int fuelType = entrada.readInt();

            /*saida.writeLong(timeStamp);
            saida.writeUTF(autoID);
            saida.writeDouble(speed);
            saida.writeDouble(fuelConsumption);
            saida.writeDouble(co2Emission);
            saida.writeDouble(x_Position);
             saida.writeDouble(y_Position);
            saida.writeInt(fuelType);*/
            //String novaMensagem = mensagem.toUpperCase();
            //DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
            //saida.writeUTF(novaMensagem);
            //GerenciadorCheques g = new GerenciadorCheques(mensagem);
            //System.out.println(m1);
            GeraRelatorio g = new GeraRelatorio(autoID,timeStamp,speed,fuelConsumption,co2Emission,x_Position,y_Position,fuelType);
            g.start();
            //g.gerarRelatorio();
            entrada.close();
            //saida.close();
            
            socket.close();

        }catch(IOException ioe){
            System.out.println("erro" + ioe.toString());
        }
    }
}