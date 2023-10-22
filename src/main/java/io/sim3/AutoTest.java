package io.sim3;

import org.junit.Test;
//import org.junit.Assert;

public class AutoTest {
    AutoTest(){

    }
    
    @Test
    public void TestarAuto(int i){
        Carro carro = new Carro();
        
        String c=carro.RetornaCar(i);
        System.out.println(c);
        //Assert.assertEquals(c, "CAR0");
    }
}
