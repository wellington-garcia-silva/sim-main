package io.sim4;

/**
 * Hello world!
 * Inicia toda a aplicação
 */

public class AppInicio2 {
    public static void main( String[] args ) {
        EnvSimulator ev = new EnvSimulator();
        ev.start();//Inicia a thread
    }
}
