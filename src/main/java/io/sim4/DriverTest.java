package io.sim4;

import org.junit.Test;
//import org.junit.Assert;

public class DriverTest {
    DriverTest(){

    }
    
    @Test
    public void RetornaDriver(int i){
        Driver driver = new Driver();
        String d=driver.RetornaDriver(i);
        System.out.println(d);
        //Assert.assertEquals("Car0", d);
    }
}
