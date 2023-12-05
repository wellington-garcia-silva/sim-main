package io.sim4;

public class Carro {
    private String car;
    Carro(){

    }
    

    public String RetornaCar(int i){
        //i = i + 7;
        //String car = Integer.toString(i);
        car = "CAR" + Integer.toString(i);;
        return car;
    }
    
}
