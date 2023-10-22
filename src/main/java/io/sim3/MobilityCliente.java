package io.sim3;

//import java.io.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import org.python.modules.thread.thread;
import org.jasypt.encryption.StringEncryptor;



public class MobilityCliente extends Thread{//carro - Cliente Servidor - Esta classe é cliente e servidor ao mesmo tempo
    private Conta contMobility;//conta tem saldo
    //cliente recebe, servidor para
    MobilityCliente(){
        //InetAddress enderecoIP = InetAddress.getLocalHost();
        //colocar aqui todos as rotas a serem percorridas 
        Conta contMobility = new Conta(100);
    }
    public void IniciaComunicacao(){
        /*try{
            
            StringEncryptor encryptor = new StandardPBEStringEncryptor();
            //encryptor.setPassword("my-secret-password");

            Conta contMobility = new Conta(100);

            Socket socket = new Socket("localhost",4000);//"192.168.0.107" - Para ser Cliente
            //ServerSocket servidorSocket = new ServerSocket(4500);

            //DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
            //saida.writeUTF("wellington");
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            //DataOutputStream saida = new DataOutputStream(servidorSocket.getOutputStream());
            //String novaMensagem = entrada.readUTF();
            //System.out.println(novaMensagem);
            System.out.println("Cliente Wm" );
            int valor = entrada.readInt();//recebe o pagamento do banco
            String Valor = entrada.readUTF();

            String decryptedData = encryptor.decrypt(Valor);  
            int valor1 = Integer.parseInt(decryptedData);     

            //System.out.println(valor);
            contMobility.setRecebimento(valor1);
           
            entrada.close();
            //saida.close();

            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }*/
    }
    //@Override
    public void run(){
        try{
            
            StringEncryptor encryptor = new StandardPBEStringEncryptor();
            //encryptor.setPassword("my-secret-password");

            

            Socket socket = new Socket("localhost",4000);//"192.168.0.107" - Para ser Cliente
            //ServerSocket servidorSocket = new ServerSocket(4500);

            //DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
            //saida.writeUTF("wellington");
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            //DataOutputStream saida = new DataOutputStream(servidorSocket.getOutputStream());
            //String novaMensagem = entrada.readUTF();
            //System.out.println(novaMensagem);
            System.out.println("Cliente Wm" );
            Double valor = entrada.readDouble();//recebe o pagamento do banco
            String Valor = entrada.readUTF();

            String decryptedData = encryptor.decrypt(Valor);  
            int valor1 = Integer.parseInt(decryptedData);     

            //System.out.println(valor);
            contMobility.setRecebimento(valor1);
           
            entrada.close();
            //saida.close();

            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //public static void main(String[] args )throws IOException {
        //ServerSocket servidorSocket = new ServerSocket(54321, 0, null);
        
        
    //}
    private class ClienteHandler implements Runnable {//Mudar para Botpayment
        private Socket socket;
        private ServerSocket s1;
        
        public ClienteHandler(Socket socket) {
            this.socket = socket;
        }
        
        @Override
        public void run() {
        try {
                // Lê a mensagem do cliente
                InputStream in = socket.getInputStream();
                //BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                //String mensagem = reader.readLine();
                //System.out.println("Mensagem do cliente: " + mensagem);
                
                // Fecha a conexão
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void pagamentoPorRota(){
        contMobility.setRecebimento(10);
    }
}


