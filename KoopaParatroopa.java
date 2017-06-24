package com.example.christian.supermarioassignment_4;

/**
 * Created by Christian on 5/30/2017.
 */

public class KoopaParatroopa implements Runnable
{
    private Thread koopaparatroopa;
    private String threadName;
    private int y;
    private int x;
    private int type;
    private int jumpcounter;
    private int jumpcounterprev;
    private int slidecounter;
    private int slidedirection;
    public KoopaParatroopa(int newx, int newy, int newtype)
    {
        threadName = "KoopaParatroopa";
        System.out.println("Creating " +  threadName + " thread" );
        y = newy;
        x = newx;
        type = newtype;
        jumpcounter = 0;
        jumpcounterprev = 0;
        slidecounter = 0;
        slidedirection = 0; //left
    }
    public static void jumping(int[][] level, KoopaParatroopa koopaparatroopa) {
        if(koopaparatroopa.type != 0) { //green only
            return;
        }
        if(level[koopaparatroopa.y + 1][koopaparatroopa.x] == 1 || level[koopaparatroopa.y + 1][koopaparatroopa.x] == 2 || level[koopaparatroopa.y + 1][koopaparatroopa.x] == 3) {
            if(level[koopaparatroopa.y - 1][koopaparatroopa.x + 1] != 1 && level[koopaparatroopa.y - 1][koopaparatroopa.x + 1] != 2 && level[koopaparatroopa.y - 1][koopaparatroopa.x + 1] != 3) {
                koopaparatroopa.jumpcounter = 1; //started jump
                koopaparatroopa.jumpcounterprev = 0;
                level[koopaparatroopa.y][koopaparatroopa.x] = 0;
                koopaparatroopa.x++;
                koopaparatroopa.y--;
                level[koopaparatroopa.y][koopaparatroopa.x] = 9;
            }
            else {
                koopaparatroopa.jumpcounter = 0; //didn't jump
                koopaparatroopa.jumpcounterprev = 0;
                level[koopaparatroopa.y][koopaparatroopa.x] = 0;
                koopaparatroopa.x++;
                level[koopaparatroopa.y][koopaparatroopa.x] = 9;
            }
        }
        else {
            if(koopaparatroopa.jumpcounter == 1 && koopaparatroopa.jumpcounterprev == 0) {
                if(level[koopaparatroopa.y - 1][koopaparatroopa.x] != 1 && level[koopaparatroopa.y - 1][koopaparatroopa.x] != 2 && level[koopaparatroopa.y - 1][koopaparatroopa.x] != 3) {
                    koopaparatroopa.jumpcounter = 2; //higher in first half of jump
                    koopaparatroopa.jumpcounterprev = 1;
                    level[koopaparatroopa.y][koopaparatroopa.x] = 0;
                    koopaparatroopa.x++;
                    koopaparatroopa.y--;
                    level[koopaparatroopa.y][koopaparatroopa.x] = 9;
                }
                else {
                    koopaparatroopa.jumpcounter = 1; //obstructed, starting to fall
                    koopaparatroopa.jumpcounterprev = 2;
                    level[koopaparatroopa.y][koopaparatroopa.x] = 0;
                    koopaparatroopa.x++;
                    koopaparatroopa.y++;
                    level[koopaparatroopa.y][koopaparatroopa.x] = 9;
                }
            }
            else if(koopaparatroopa.jumpcounter == 2 && koopaparatroopa.jumpcounterprev == 1) {
                if(level[koopaparatroopa.y + 1][koopaparatroopa.x + 1] != 1 && level[koopaparatroopa.y + 1][koopaparatroopa.x + 1] != 2 && level[koopaparatroopa.y + 1][koopaparatroopa.x + 1] != 3) {
                    koopaparatroopa.jumpcounter = 1; //falling after peak
                    koopaparatroopa.jumpcounterprev = 2;
                    level[koopaparatroopa.y][koopaparatroopa.x] = 0;
                    koopaparatroopa.x++;
                    koopaparatroopa.y++;
                    level[koopaparatroopa.y][koopaparatroopa.x] = 9;
                }
                else {
                    koopaparatroopa.jumpcounter = 0; //landed on platform at peak
                    koopaparatroopa.jumpcounterprev = 0;
                    level[koopaparatroopa.y][koopaparatroopa.x] = 0;
                    koopaparatroopa.x++;
                    level[koopaparatroopa.y][koopaparatroopa.x] = 9;
                }
            }
            else if(koopaparatroopa.jumpcounter == 1 && koopaparatroopa.jumpcounterprev == 2) {
                if(level[koopaparatroopa.y + 1][koopaparatroopa.x + 1] != 1 && level[koopaparatroopa.y + 1][koopaparatroopa.x + 1] != 2 && level[koopaparatroopa.y + 1][koopaparatroopa.x + 1] != 3) {
                    koopaparatroopa.jumpcounter = 0; //back at level where jump started
                    koopaparatroopa.jumpcounterprev = 1;
                    level[koopaparatroopa.y][koopaparatroopa.x] = 0;
                    koopaparatroopa.x++;
                    koopaparatroopa.y++;
                    level[koopaparatroopa.y][koopaparatroopa.x] = 9;
                }
                else {
                    koopaparatroopa.jumpcounter = 0; //platform in path, walk
                    koopaparatroopa.jumpcounterprev = 0;
                    level[koopaparatroopa.y][koopaparatroopa.x] = 0;
                    koopaparatroopa.x++;
                    level[koopaparatroopa.y][koopaparatroopa.x] = 9;
                }
            }
            else {
                if(level[koopaparatroopa.y + 1][koopaparatroopa.x + 1] != 1 && level[koopaparatroopa.y + 1][koopaparatroopa.x + 1] != 2 && level[koopaparatroopa.y + 1][koopaparatroopa.x + 1] != 3) {
                    koopaparatroopa.jumpcounter = 0; //keep falling
                    koopaparatroopa.jumpcounterprev = 0;
                    level[koopaparatroopa.y][koopaparatroopa.x] = 0;
                    koopaparatroopa.x++;
                    koopaparatroopa.y++;
                    level[koopaparatroopa.y][koopaparatroopa.x] = 9;
                }
                else {
                    koopaparatroopa.jumpcounter = 0; //stop falling
                    koopaparatroopa.jumpcounterprev = 0;
                    level[koopaparatroopa.y][koopaparatroopa.x] = 0;
                    koopaparatroopa.x++;
                    level[koopaparatroopa.y][koopaparatroopa.x] = 9;
                }
            }
        }
    }

    public void hover(int[][] level, KoopaParatroopa koopaparatroopa) {
        if(koopaparatroopa.type != 1) { //red only
            return;
        }
        if(koopaparatroopa.jumpcounter == 1 && koopaparatroopa.jumpcounterprev == 0) {
            koopaparatroopa.jumpcounter = 0;
            koopaparatroopa.jumpcounterprev = 1;
            level[koopaparatroopa.y][koopaparatroopa.x] = 0;
            koopaparatroopa.y++;
            level[koopaparatroopa.y][koopaparatroopa.x] = 9;
        }
        else if(koopaparatroopa.jumpcounter == 0 && koopaparatroopa.jumpcounterprev == 1) {
            koopaparatroopa.jumpcounter = -1;
            koopaparatroopa.jumpcounterprev = 0;
            level[koopaparatroopa.y][koopaparatroopa.x] = 0;
            koopaparatroopa.y++;
            level[koopaparatroopa.y][koopaparatroopa.x] = 9;
        }
        else if(koopaparatroopa.jumpcounter == 0 && koopaparatroopa.jumpcounterprev == -1) {
            koopaparatroopa.jumpcounter = 1;
            koopaparatroopa.jumpcounterprev = 0;
            level[koopaparatroopa.y][koopaparatroopa.x] = 0;
            koopaparatroopa.y--;
            level[koopaparatroopa.y][koopaparatroopa.x] = 9;
        }
        else {
            koopaparatroopa.jumpcounter = 0;
            koopaparatroopa.jumpcounterprev = -1;
            level[koopaparatroopa.y][koopaparatroopa.x] = 0;
            koopaparatroopa.y--;
            level[koopaparatroopa.y][koopaparatroopa.x] = 9;
        }
    }

    public void shellslide(int[][] level, KoopaParatroopa koopaparatroopa, Mario mario) {
        if(mario.y + 1 == koopaparatroopa.y) { //if mario on top of shell
            if(koopaparatroopa.type > 1) { //shell form
                if(koopaparatroopa.slidecounter == 0) {
                    koopaparatroopa.slidecounter = 1; //start sliding
                    koopaparatroopa.slidedirection = 0;
                }
                else {
                    koopaparatroopa.slidecounter = 0; //stop sliding
                }
            }
            else {
                if(koopaparatroopa.type == 0) {
                    koopaparatroopa.type = 2;
                }
                else {
                    koopaparatroopa.type = 3;
                }
            }
        }
        if(koopaparatroopa.slidecounter == 1) {
            if(koopaparatroopa.slidedirection == 0) {
                level[koopaparatroopa.y][koopaparatroopa.x] = 0;
                koopaparatroopa.x--;
                if(koopaparatroopa.type == 2) {
                    level[koopaparatroopa.y][koopaparatroopa.x] = 10;
                }
                else {
                    level[koopaparatroopa.y][koopaparatroopa.x] = 12;
                }
            }
            else {
                level[koopaparatroopa.y][koopaparatroopa.x] = 0;
                koopaparatroopa.x++;
                if(koopaparatroopa.type == 2) {
                    level[koopaparatroopa.y][koopaparatroopa.x] = 10;
                }
                else {
                    level[koopaparatroopa.y][koopaparatroopa.x] = 12;
                }
            }
        }
        //handling falling shell
        if(level[koopaparatroopa.y + 1][koopaparatroopa.x] != 1 && level[koopaparatroopa.y + 1][koopaparatroopa.x] != 2 && level[koopaparatroopa.y + 1][koopaparatroopa.x] != 3 && koopaparatroopa.type > 1) {
            level[koopaparatroopa.y][koopaparatroopa.x] = 0;
            koopaparatroopa.y++;
            if(koopaparatroopa.type == 2) { //green shell
                level[koopaparatroopa.y][koopaparatroopa.x] = 10;
            }
            else { //red shell
                level[koopaparatroopa.y][koopaparatroopa.x] = 12;
            }
        }
    }

    public void run()
    {
        System.out.println("Running " +  threadName );
        try
        {
                Thread.sleep(50);
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
        if (koopaparatroopa == null)
        {
            koopaparatroopa = new Thread (this, threadName);
            koopaparatroopa.start ();

        }
    }
}

