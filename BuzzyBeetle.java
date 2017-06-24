package com.example.christian.supermarioassignment_4;

/**
 * Created by Christian on 5/30/2017.
 */

public class BuzzyBeetle implements Runnable
{
    private Thread buzzybeetle;
    private String threadName;
    private static int y;
    private static int x;
    private static int type;
    private static int direction;
    private static int slidecounter;
    private static int slidedirection;

    BuzzyBeetle(int newx, int newy)
    {
        threadName = "BuzzyBeetle";
        System.out.println("Creating " +  threadName + " thread" );
        x = newx;
        y = newy;
        type = 1;
        slidecounter = 0;
        slidedirection = 0;
        direction = 1;
    }

    public void patrol(int[][] level, BuzzyBeetle buzzybeetle) {
        if(buzzybeetle.type == 2) {
            return;
        }
        if(level[buzzybeetle.y][buzzybeetle.x + 1] != 1 && level[buzzybeetle.y][buzzybeetle.x + 1] != 2 && level[buzzybeetle.y][buzzybeetle.x + 1] != 3 && buzzybeetle.direction == 1) {
            level[buzzybeetle.y][buzzybeetle.x] = 0;
            buzzybeetle.x++;
            level[buzzybeetle.y][buzzybeetle.x] = 7;
        }
        else if(level[buzzybeetle.y][buzzybeetle.x - 1] != 1 && level[buzzybeetle.y][buzzybeetle.x - 1] != 2 && level[buzzybeetle.y][buzzybeetle.x - 1] != 3 && buzzybeetle.direction == 0) {
            level[buzzybeetle.y][buzzybeetle.x] = 0;
            buzzybeetle.x--;
            level[buzzybeetle.y][buzzybeetle.x] = 6;
        }
        else {
            if(buzzybeetle.direction == 1) {
                buzzybeetle.direction = 0;
            }
            else {
                buzzybeetle.direction = 1;
            }
        }
    }

    public void shellslide(int[][] level, BuzzyBeetle buzzybeetle, Mario mario) {
        if(mario.y + 1 == buzzybeetle.y) { //if mario on top of shell
            if(buzzybeetle.type > 1) { //shell form
                if(buzzybeetle.slidecounter == 0) {
                    buzzybeetle.slidecounter = 1; //start sliding
                    buzzybeetle.slidedirection = 0;
                }
                else {
                    buzzybeetle.slidecounter = 0; //stop sliding
                }
            }
        }
        if(buzzybeetle.slidecounter == 1) {
            if(buzzybeetle.slidedirection == 0) {
                level[buzzybeetle.y][buzzybeetle.x] = 0;
                buzzybeetle.x--;
                if(buzzybeetle.type == 2) {
                    level[buzzybeetle.y][buzzybeetle.x] = 10;
                }
                else {
                    level[buzzybeetle.y][buzzybeetle.x] = 12;
                }
            }
            else {
                level[buzzybeetle.y][buzzybeetle.x] = 0;
                buzzybeetle.x++;
                if(buzzybeetle.type == 2) {
                    level[buzzybeetle.y][buzzybeetle.x] = 10;
                }
                else {
                    level[buzzybeetle.y][buzzybeetle.x] = 12;
                }
            }
        }
    }

    public void falling(int[][] level, BuzzyBeetle buzzybeetle) {
        //handling falling
        if(level[buzzybeetle.y + 1][buzzybeetle.x] != 1 && level[buzzybeetle.y + 1][buzzybeetle.x] != 2 && level[buzzybeetle.y + 1][buzzybeetle.x] != 3) {
            level[buzzybeetle.y][buzzybeetle.x] = 0;
            buzzybeetle.y++;
            if(buzzybeetle.type == 2) {
                level[buzzybeetle.y][buzzybeetle.x] = 10;
            }
            else {
                level[buzzybeetle.y][buzzybeetle.x] = 12;
            }
        }
    }

    public void run()
    {
        System.out.println("Running " +  threadName );
        try
        {
            for(int i = 0; i < 2; i++)
            {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start ()
    {
        System.out.println("Starting " +  threadName );
        if (buzzybeetle == null)
        {
            buzzybeetle = new Thread (this, threadName);
            buzzybeetle.start ();

        }
    }
}