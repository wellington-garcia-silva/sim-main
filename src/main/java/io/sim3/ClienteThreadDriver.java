package io.sim3;



import java.io.DataOutputStream;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
//import java.net.ServerSocket;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class ClienteThreadDriver extends Thread{
    private Socket socket;
    private Conta contaDriver;
    public ClienteThreadDriver(Socket s){
        this.socket = s;
        contaDriver = new Conta(100);
    }
    public void run(){
        System.out.println(Thread.currentThread().getName());
        try{
            DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
            //int valor = saida.readInt();
            int valorDriver=10;
            int valorFuelStation=10;
            int valorMobility=10;
            saida.writeInt(valorDriver);
            saida.writeInt(valorFuelStation);
            saida.writeInt(valorMobility);

            contaDriver.setPagamento(valorDriver);
            contaDriver.setPagamento(valorFuelStation);
            contaDriver.setPagamento(valorMobility);

            contaDriver.getSaldo();
            //String mensagem = entrada.readUTF();
            
            //ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
            //String novaMensagem = mensagem.toUpperCase();
            //DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
            //saida.writeUTF(novaMensagem);
            //tem que ser enviado o pagamento!!!!!!!

            //entrada.close();
            saida.close();
            
            socket.close();

        }catch(IOException ioe){
            System.out.println("erro" + ioe.toString());
        }
    }
}