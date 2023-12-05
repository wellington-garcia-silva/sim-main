package io.sim4;

public class Reconciliacao extends Thread{
    private double distanciaTotal;
    private double speed;

    private double tempoInicial;
    private double tempoFinal;
    private double tempoTrajetoria;
    private double tempo1;
    private double tempo2;
    private double tempo3;
    
    Reconciliacao(double speed, double tempoInicial, double tempoFinal,double tempo1,double tempo2,double tempo3){
        this.tempoFinal=tempoFinal;
        this.tempoInicial=tempoInicial;
        this.speed=speed;
        this.tempo1=tempo1;
        this.tempo2=tempo2;
        this.tempo3=tempo3;
    }
    public void run(){
        //tempoTrajetoria= " ";
        //distanciaTotal = null 
        tempoTrajetoria = tempoFinal-tempoInicial;
        tempo1=tempo1-tempoInicial;
        tempo2=tempo2-tempo1;
        //tempo3=



    }
}
