package io.sim3;


import java.io.DataOutputStream;
import java.net.Socket;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
//import java.net.ServerSocket;

public class ClienteThreadMobility extends Thread{
    private Socket socket;
    private Conta contaMobility;

    //private Banco 
    public ClienteThreadMobility(Socket s){
        this.socket = s;
        contaMobility = new Conta(0);//Na verdade oneste momento o banco faz o pagamento
    }
    public void run(){
        System.out.println(Thread.currentThread().getName());
        try{
            StringEncryptor encryptor = new StandardPBEStringEncryptor();
            //encryptor.setPassword("my-secret-password");
            String Valor = "5,87";
            String encryptedData = encryptor.encrypt(Valor);
            //DataInputStream entrada = new DataInputStream(socket.getInputStream());
            //String mensagem = entrada.readUTF();
            //String novaMensagem = mensagem.toUpperCase();
            //criar a conta do Banco
            //Conta contaBanco = new Conta(100);
            DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
            int valor = 10;
            //saida.writeInt(valor);
            saida.writeUTF(encryptedData);
            contaMobility.setPagamento(valor);//Aqui o banco paga
            System.out.println("aceitokkk" );
            //entrada.close();
            saida.close();
            
            socket.close();

            

        }catch(IOException ioe){
            System.out.println("erro" + ioe.toString());
        }
    }
}

