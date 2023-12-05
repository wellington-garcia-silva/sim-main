package io.sim4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.io.InputStreamReader;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class ClienteThreadFuelStation extends Thread{
    private Socket socket;
    private Conta contaFuelStation;
    public ClienteThreadFuelStation(Socket socket){
        this.socket = socket;
        contaFuelStation = new Conta(100);
    }

    @Override
    public void run(){
        try{ /*
            InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
            PrintStream saida = new PrintStream(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(inputReader);
            String x;
            while((x = reader.readLine()) != null){
                System.out.println(x);
            }*/
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            //String mensagem = entrada.readUTF();
            //String novaMensagem = mensagem.toUpperCase();
            DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
            //Double v = saida.readDouble();
            Double fuelConsumption = entrada.readDouble();
            contaFuelStation.setRecebimento(6);
            //saida.writeUTF(novaMensagem);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
