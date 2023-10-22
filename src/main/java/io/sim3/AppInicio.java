package io.sim3;

/**
 * Hello world!
 * Inicia toda a aplicação
 */

public class AppInicio {
    public static void main( String[] args ) {
        EnvSimulator ev = new EnvSimulator();
        ev.start();//Inicia a thread
    }
}
