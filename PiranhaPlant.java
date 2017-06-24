package com.example.christian.supermarioassignment_4;

/**
 * Created by Christian on 5/30/2017.
 */

public class PiranhaPlant implements Runnable {
    private Thread piranhaplant;
    private String threadName;
    private int x;
    private int y;

    PiranhaPlant(int newx, int newy)
    {
        threadName = "PiranhaPlant";
        System.out.println("Creating " +  threadName + " thread" );
        x = newx;
        y = newy;
    }


    public void rise(int[][] level, PiranhaPlant piranhaplant, Mario mario) {
        if(mario.x - piranhaplant.x > 3) {
            level[piranhaplant.y][piranhaplant.x] = 5;
        }
    }

    public void run()
    {
        System.out.println("Running " +  threadName );
        try
        {
            for(int i = 0; i < 10; i++)
            {

                Thread.sleep(3000);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }


    public void start()
    {
        System.out.println("Starting " +  threadName );
        if (piranhaplant == null)
        {
            piranhaplant = new Thread (this, threadName);
            piranhaplant.start ();
        }
    }
}
