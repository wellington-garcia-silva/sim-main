package io.sim4;

//import java.io.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class FuelStationCliente extends Thread{//carro
    private Conta contaFuelStation;
    FuelStationCliente(){
        
    }
    //public void IniciaFuelStation(){
    public void run(){
        try{
            Conta contaFuelStation = new Conta(0.0);
            Socket socket = new Socket("localhost",4000);//"192.168.0.107" enderecoIP
            //DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
            //saida.writeUTF("wellington");
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            //String novaMensagem = entrada.readUTF();
            //System.out.println(novaMensagem);
            //System.out.println("Cliente mmm" );
            int valor = entrada.readInt();
            contaFuelStation.setRecebimento(valor);
            System.out.println("pago");

            entrada.close();
            //saida.close();

            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //public static void main(String[] args )throws IOException {
        //ServerSocket servidorSocket = new ServerSocket(54321, 0, null);
        //InetAddress enderecoIP = InetAddress.getLocalHost();
        
        
    //}
}


