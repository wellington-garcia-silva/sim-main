package io.sim4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class CompanyMobility extends Thread{
    private ArrayList<Rotas> rotasASeremExecutadoas;
    private ArrayList<Rotas> rotasEmExecucao;
    private ArrayList<Rotas> rotasExecutadas;
	private Rotas rota;

    public CompanyMobility(){
		rotasASeremExecutadoas = new ArrayList<Rotas>();
        rotasEmExecucao = new ArrayList<Rotas>();
        rotasExecutadas = new ArrayList<Rotas>();
    }
    
}
    /* 
    public static void main(String[] args )throws IOException {
        //ServerSocket servidorSocket = new ServerSocket(54321, 0, null);
        InetAddress enderecoIP = InetAddress.getLocalHost();
        try{
            Socket socket = new Socket(enderecoIP,4000);//"192.168.0.107"
            DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
            //saida.writeUTF("wellington");
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            String novaMensagem = entrada.readUTF();
            System.out.println(novaMensagem);
            System.out.println("Cliente mmm" );

            entrada.close();
            saida.close();

            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }

    //public void run(){

    //}
    
}*/
