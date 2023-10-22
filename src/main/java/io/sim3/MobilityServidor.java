package io.sim3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
//import java.net.HostAddress;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
//import org.junit.jupiter.api.Assertions;


public class MobilityServidor extends Thread{

    MobilityServidor(){

    }
    //public static void main(String[] args )throws IOException {//
    //public void iniciarServidor() {
    public void run(){
       
        try {
            ServerSocket servidorSocket = new ServerSocket(4500);
            System.out.println("Servidor!W!");
            System.out.println("aceito" );
           
            System.out.println("aceito" );

            ObjectMapper mapper = new ObjectMapper();

            // Cria um objeto Java
            //Person person = new Person("John Doe", 30);
    
            // Serializa o objeto Java em JSON
            //String json = mapper.writeValueAsString(person);
    
            // Imprime o JSON
            //System.out.println(json);
    
            // Desserializa o JSON em um objeto Java
            //Person person2 = mapper.readValue(json, Person.class);
    
            // Imprime o objeto Java
            //System.out.println(person2);

            // Gera um objeto Person a partir do JSON
            //Person person = mapper.readValue(json, Person.class);
    
            // Imprime o objeto Java
            //System.out.println(person);

            while(true){
            //for(int i=0;i<1;i++){
                Socket socket = servidorSocket.accept();
            // System.out.println("Cliente!!!" + socket.getInetAddress().getHostAddress() + "conectado");
                ClienteThreadCarro t1 = new ClienteThreadCarro(socket);
                t1.start();
                System.out.println("testeWellington" );
                
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void vv(){

    }
    
}

