package io.sim4;

public class Driver {
    private String driver;
    Driver(){
        
    }
    public String RetornaDriver(int i){
        //i = i + 9;
        //String driver = Integer.toString(i);
        this.driver = "D" + Integer.toString(i);
        return driver;
    }
}
