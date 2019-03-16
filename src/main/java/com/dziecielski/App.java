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
        Gui gui = new Gui();

        while(true){
            tank.calculate();
            gui.fetchData(tank);
            gui.refresh();
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
        
    }
}
