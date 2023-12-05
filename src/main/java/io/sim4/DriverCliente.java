package io.sim4;

//import java.io.*;
import java.io.DataInputStream;//não sei se precisa
import java.io.DataOutputStream;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DriverCliente extends Thread{//carro
    private Conta contaDriver;
    //private Conta contaDriver = new Conta();
    DriverCliente(){//Esta classe é cliente de banco
        
    }
    //public void IniciaDriver(){
    public void run(){
        try{
            Conta contaDriver = new Conta(0);//Conta do motorista
            Socket socket = new Socket("localhost",4000);//"192.168.0.107" - enderecoIP
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            //ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
            //DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
            //saida.writeObject(contaDriver);
            //saida.writeInt(10);
            int valor = entrada.readInt();
            
            contaDriver.setRecebimento(valor);
            //System.out.println("driver");

            //DataInputStream entrada = new DataInputStream(socket.getInputStream());
            //String novaMensagem = entrada.readUTF();
            //System.out.println(novaMensagem);
            //System.out.println("Cliente mmm" );
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

