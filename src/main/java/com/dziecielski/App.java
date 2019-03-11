package com.dziecielski;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Tank tank = new Tank(6.0f, 5.0f);

        for(int i=0; i<200; i++){
            tank.calculate();
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
        
    }
}
