package io.sim4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.python.modules.thread.thread;

import java.net.InetAddress;
//import java.net.HostAddress;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class BancoServidor extends Thread{
    private static Conta contaBanco;
   
    BancoServidor(){
        //ServerSocket servidorSocket = new ServerSocket(4001);
    }
    //public static void main(String[] args )throws IOException {
    public void IniciaServidorBanco(){
        /*try {
        ServerSocket servidorSocket = new ServerSocket(4001);
        //System.out.println("Servidor!!!");

        while(true){
            Socket socket = servidorSocket.accept();
            System.out.println("Cliente!!!" + socket.getInetAddress().getHostAddress() + "conectado");

            ClienteThreadMobility t1 = new ClienteThreadMobility(socket);//faz todos os pagamentos 
            ClienteThreadCarro t2 = new ClienteThreadCarro(socket);
            ClienteThreadDriver t3 = new ClienteThreadDriver(socket);
            //System.out.println("teste" );
            t1.start();
            t2.start();
            t3.start();

        }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
    public void run(){
        try {
        ServerSocket servidorSocket = new ServerSocket(4000);
        //System.out.println("Servidor!!!");

        while(true){
            Socket socket = servidorSocket.accept();
            System.out.println("Cliente!!!" + socket.getInetAddress().getHostAddress() + "conectado");

            ClienteThreadMobility t1 = new ClienteThreadMobility(socket);//faz todos os pagamentos 
            ClienteThreadFuelStation t2 = new ClienteThreadFuelStation(socket);
            ClienteThreadDriver t3 = new ClienteThreadDriver(socket);
            //System.out.println("teste" );
            //t1.start();
            t1.start();
            t2.start();
            t3.start();
            try {
                t1.join();
                t2.join();
                t3.join();
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

