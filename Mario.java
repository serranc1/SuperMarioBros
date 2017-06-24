package com.example.christian.supermarioassignment_4;

/**
 * Created by Christian on 5/30/2017.
 */

public class Mario implements Runnable
{
    private Thread mario;
    private String threadName;
    public int x;
    public int y;
    public int type;
    private int jumpcounter;
    private int jumpcounterprev;
    public int direction;


    Mario(int newx, int newy, int newtype)
    {
        threadName = "Mario";
        System.out.println("Creating " +  threadName + " thread" );
        x = newx;
        y = newy;
        jumpcounter = 0;
        jumpcounterprev = 0;
        type = newtype;
        direction = 0;
    }

    public static void walking(int[][] level, Mario mario) {
        if(mario.direction == 0) { //walk left
            level[mario.y][mario.x] = 0;
            mario.x--;
            if(mario.type == 0) {
                level[mario.y][mario.x] = 18;
            }
            else if(mario.type == 1) {
                level[mario.y][mario.x] = 24;
            }
            else {
                level[mario.y][mario.x] = 32;
            }
        }
        else { //walk right
            level[mario.y][mario.x] = 0;
            mario.x++;
            if(mario.type == 0) {
                level[mario.y][mario.x] = 19;
            }
            else if(mario.type == 1) {
                level[mario.y][mario.x] = 25;
            }
            else {
                level[mario.y][mario.x] = 33;
            }
        }
    }
    public static int verticaljumping(int[][] level, Mario mario) {
        if(level[mario.y + 1][mario.x] == 1 || level[mario.y + 1][mario.x] == 2 || level[mario.y + 1][mario.x] == 3) {
            if(level[mario.y - 1][mario.x] != 1 && level[mario.y - 1][mario.x] != 2 && level[mario.y - 1][mario.x] != 3) {
                mario.jumpcounter = 1; //started jump
                mario.jumpcounterprev = 0;
                level[mario.y][mario.x] = 0;
                mario.y--;
                if(mario.direction == 0) {
                    level[mario.y][mario.x] = 20;
                }
                else {
                    level[mario.y][mario.x] = 21;
                }
                return 3;
            }
            else {
                mario.jumpcounter = 0; //didn't jump
                mario.jumpcounterprev = 0;
                if(mario.direction == 0) {
                    level[mario.y][mario.x] = 16;
                }
                else {
                    level[mario.y][mario.x] = 17;
                }
                return 0;
            }
        }
        else {
            if(mario.jumpcounter == 1 && mario.jumpcounterprev == 0) {
                if(level[mario.y - 1][mario.x] != 1 && level[mario.y - 1][mario.x] != 2 && level[mario.y - 1][mario.x] != 3) {
                    mario.jumpcounter = 2; //higher in first half of jump
                    mario.jumpcounterprev = 1;
                    level[mario.y][mario.x] = 0;
                    mario.y--;
                    if(mario.direction == 0) {
                        level[mario.y][mario.x] = 20;
                    }
                    else {
                        level[mario.y][mario.x] = 21;
                    }
                    return 3;
                }
                else {
                    mario.jumpcounter = 1; //obstructed, starting to fall
                    mario.jumpcounterprev = 2;
                    level[mario.y][mario.x] = 0;
                    mario.y++;
                    if(mario.direction == 0) {
                        level[mario.y][mario.x] = 20;
                    }
                    else {
                        level[mario.y][mario.x] = 21;
                    }
                    return 3;
                }
            }
            else if(mario.jumpcounter == 2 && mario.jumpcounterprev == 1) {
                if(level[mario.y + 1][mario.x] != 1 && level[mario.y + 1][mario.x] != 2 && level[mario.y + 1][mario.x] != 3) {
                    mario.jumpcounter = 3;
                    mario.jumpcounterprev = 2;
                    level[mario.y][mario.x] = 0;
                    mario.y--;
                    if(mario.direction == 0) {
                        level[mario.y][mario.x] = 20;
                    }
                    else {
                        level[mario.y][mario.x] = 21;
                    }
                    return 3;
                }
                else {
                    mario.jumpcounter = 2; //obstructed, starting to fall
                    mario.jumpcounterprev = 3;
                    level[mario.y][mario.x] = 0;
                    mario.y++;
                    if(mario.direction == 0) {
                        level[mario.y][mario.x] = 20;
                    }
                    else {
                        level[mario.y][mario.x] = 21;
                    }
                    return 3;
                }
            }
            else if(mario.jumpcounter == 3 && mario.jumpcounterprev == 2) {
                if(level[mario.y + 1][mario.x] != 1 && level[mario.y + 1][mario.x] != 2 && level[mario.y + 1][mario.x] != 3) {
                    mario.jumpcounter = 2; //falling after peak
                    mario.jumpcounterprev = 3;
                    level[mario.y][mario.x] = 0;
                    mario.y++;
                    if(mario.direction == 0) {
                        level[mario.y][mario.x] = 20;
                    }
                    else {
                        level[mario.y][mario.x] = 21;
                    }
                    return 3;
                }
                return 0;
            }
            else if(mario.jumpcounter == 2 && mario.jumpcounterprev == 3) {
                if(level[mario.y + 1][mario.x] != 1 && level[mario.y + 1][mario.x] != 2 && level[mario.y + 1][mario.x] != 3) {
                    mario.jumpcounter = 1;
                    mario.jumpcounterprev = 2;
                    level[mario.y][mario.x] = 0;
                    mario.y++;
                    if(mario.direction == 0) {
                        level[mario.y][mario.x] = 20;
                    }
                    else {
                        level[mario.y][mario.x] = 21;
                    }
                    return 3;
                }
                return 0;
            }
            else if(mario.jumpcounter == 1 && mario.jumpcounterprev == 2) {
                if(level[mario.y + 1][mario.x] != 1 && level[mario.y + 1][mario.x] != 2 && level[mario.y + 1][mario.x] != 3) {
                    mario.jumpcounter = 0; //back at level where jump started
                    mario.jumpcounterprev = 1;
                    level[mario.y][mario.x] = 0;
                    mario.y++;
                    if(mario.direction == 0) {
                        level[mario.y][mario.x] = 20;
                    }
                    else {
                        level[mario.y][mario.x] = 21;
                    }
                    return 3;
                }
                return 0;
            }
            else {
                if(level[mario.y + 1][mario.x] != 1 && level[mario.y + 1][mario.x] != 2 && level[mario.y + 1][mario.x] != 3) {
                    mario.jumpcounter = 0; //keep falling
                    mario.jumpcounterprev = 0;
                    level[mario.y][mario.x] = 0;
                    mario.y++;
                    if(mario.direction == 0) {
                        level[mario.y][mario.x] = 20;
                    }
                    else {
                        level[mario.y][mario.x] = 21;
                    }
                    return 3;
                }
                return 0;
            }
        }
    }
    public static int leftjumping(int[][] level, Mario mario) {
        mario.direction = 0;
        if(level[mario.y + 1][mario.x] == 1 || level[mario.y + 1][mario.x] == 2 || level[mario.y + 1][mario.x] == 3) {
            if(level[mario.y - 1][mario.x - 1] != 1 && level[mario.y - 1][mario.x - 1] != 2 && level[mario.y - 1][mario.x - 1] != 3) {
                mario.jumpcounter = 1; //started jump
                mario.jumpcounterprev = 0;
                level[mario.y][mario.x] = 0;
                mario.x--;
                mario.y--;
                level[mario.y][mario.x] = 20;
                return 1;
            }
            else {
                mario.jumpcounter = 0; //didn't jump
                mario.jumpcounterprev = 0;
                level[mario.y][mario.x] = 16;
                return 0;
            }
        }
        else {
            if(mario.jumpcounter == 1 && mario.jumpcounterprev == 0) {
                if(level[mario.y - 1][mario.x] != 1 && level[mario.y - 1][mario.x] != 2 && level[mario.y - 1][mario.x] != 3) {
                    mario.jumpcounter = 2; //higher in first half of jump
                    mario.jumpcounterprev = 1;
                    level[mario.y][mario.x] = 0;
                    mario.x--;
                    mario.y--;
                    level[mario.y][mario.x] = 20;
                }
                else {
                    mario.jumpcounter = 1; //obstructed, starting to fall
                    mario.jumpcounterprev = 2;
                    level[mario.y][mario.x] = 0;
                    mario.x--;
                    mario.y++;
                    level[mario.y][mario.x] = 20;
                }
                return 1;
            }
            else if(mario.jumpcounter == 2 && mario.jumpcounterprev == 1) {
                if(level[mario.y + 1][mario.x - 1] != 1 && level[mario.y + 1][mario.x - 1] != 2 && level[mario.y + 1][mario.x - 1] != 3) {
                    mario.jumpcounter = 3;
                    mario.jumpcounterprev = 2;
                    level[mario.y][mario.x] = 0;
                    mario.x--;
                    mario.y--;
                    level[mario.y][mario.x] = 20;
                }
                else {
                    mario.jumpcounter = 2; //obstructed, starting to fall
                    mario.jumpcounterprev = 3;
                    level[mario.y][mario.x] = 0;
                    mario.x--;
                    mario.y++;
                    level[mario.y][mario.x] = 20;
                }
                return 1;
            }
            else if(mario.jumpcounter == 3 && mario.jumpcounterprev == 2) {
                if(level[mario.y + 1][mario.x - 1] != 1 && level[mario.y + 1][mario.x - 1] != 2 && level[mario.y + 1][mario.x - 1] != 3) {
                    mario.jumpcounter = 2; //falling after peak
                    mario.jumpcounterprev = 3;
                    level[mario.y][mario.x] = 0;
                    mario.x--;
                    mario.y++;
                    level[mario.y][mario.x] = 20;
                    return 1;
                }
                else {
                    mario.jumpcounter = 0; //landed on platform at peak
                    mario.jumpcounterprev = 0;
                    level[mario.y][mario.x] = 0;
                    mario.x--;
                    level[mario.y][mario.x] = 16;
                    return 0;
                }
            }
            else if(mario.jumpcounter == 2 && mario.jumpcounterprev == 3) {
                if(level[mario.y + 1][mario.x - 1] != 1 && level[mario.y + 1][mario.x - 1] != 2 && level[mario.y + 1][mario.x - 1] != 3) {
                    mario.jumpcounter = 1;
                    mario.jumpcounterprev = 2;
                    level[mario.y][mario.x] = 0;
                    mario.x--;
                    mario.y++;
                    level[mario.y][mario.x] = 20;
                    return 1;
                }
                else {
                    mario.jumpcounter = 0; //platform in path, still
                    mario.jumpcounterprev = 0;
                    level[mario.y][mario.x] = 0;
                    level[mario.y][mario.x] = 16;
                    return 0;
                }
            }
            else if(mario.jumpcounter == 1 && mario.jumpcounterprev == 2) {
                if(level[mario.y + 1][mario.x - 1] != 1 && level[mario.y + 1][mario.x - 1] != 2 && level[mario.y + 1][mario.x - 1] != 3) {
                    mario.jumpcounter = 0; //back at level where jump started
                    mario.jumpcounterprev = 1;
                    level[mario.y][mario.x] = 0;
                    mario.x--;
                    mario.y++;
                    level[mario.y][mario.x] = 20;
                    return 1;
                }
                else {
                    mario.jumpcounter = 0; //platform in path, still
                    mario.jumpcounterprev = 0;
                    level[mario.y][mario.x] = 16;
                    return 0;
                }
            }
            else {
                if(level[mario.y + 1][mario.x - 1] != 1 && level[mario.y + 1][mario.x - 1] != 2 && level[mario.y + 1][mario.x - 1] != 3) {
                    mario.jumpcounter = 0; //keep falling
                    mario.jumpcounterprev = 0;
                    level[mario.y][mario.x] = 0;
                    mario.x--;
                    mario.y++;
                    level[mario.y][mario.x] = 20;
                    return 1;
                }
                else {
                    mario.jumpcounter = 0; //stop falling
                    mario.jumpcounterprev = 0;
                    level[mario.y][mario.x] = 0;
                    mario.x--;
                    level[mario.y][mario.x] = 16;
                    return 0;
                }
            }
        }
    }
    public static int rightjumping(int[][] level, Mario mario) {
        mario.direction = 1;
        if(level[mario.y + 1][mario.x] == 1 || level[mario.y + 1][mario.x] == 2 || level[mario.y + 1][mario.x] == 3) {
            if(level[mario.y - 1][mario.x + 1] != 1 && level[mario.y - 1][mario.x + 1] != 2 && level[mario.y - 1][mario.x + 1] != 3) {
                mario.jumpcounter = 1; //started jump
                mario.jumpcounterprev = 0;
                level[mario.y][mario.x] = 0;
                mario.x++;
                mario.y--;
                level[mario.y][mario.x] = 21;
                return 2;
            }
            else {
                mario.jumpcounter = 0; //didn't jump
                mario.jumpcounterprev = 0;
                level[mario.y][mario.x] = 17;
                return 0;
            }
        }
        else {
            if(mario.jumpcounter == 1 && mario.jumpcounterprev == 0) {
                if(level[mario.y - 1][mario.x] != 1 && level[mario.y - 1][mario.x] != 2 && level[mario.y - 1][mario.x] != 3) {
                    mario.jumpcounter = 2; //higher in first half of jump
                    mario.jumpcounterprev = 1;
                    level[mario.y][mario.x] = 0;
                    mario.x++;
                    mario.y--;
                    level[mario.y][mario.x] = 21;
                }
                else {
                    mario.jumpcounter = 1; //obstructed, starting to fall
                    mario.jumpcounterprev = 2;
                    level[mario.y][mario.x] = 0;
                    mario.x++;
                    mario.y++;
                    level[mario.y][mario.x] = 21;
                }
                return 2;
            }
            else if(mario.jumpcounter == 2 && mario.jumpcounterprev == 1) {
                if(level[mario.y + 1][mario.x + 1] != 1 && level[mario.y + 1][mario.x + 1] != 2 && level[mario.y + 1][mario.x + 1] != 3) {
                    mario.jumpcounter = 3;
                    mario.jumpcounterprev = 2;
                    level[mario.y][mario.x] = 0;
                    mario.x++;
                    mario.y--;
                    level[mario.y][mario.x] = 21;
                }
                else {
                    mario.jumpcounter = 2; //obstructed, starting to fall
                    mario.jumpcounterprev = 3;
                    level[mario.y][mario.x] = 0;
                    mario.x++;
                    mario.y++;
                    level[mario.y][mario.x] = 21;
                }
                return 2;
            }
            else if(mario.jumpcounter == 3 && mario.jumpcounterprev == 2) {
                if(level[mario.y + 1][mario.x + 1] != 1 && level[mario.y + 1][mario.x + 1] != 2 && level[mario.y + 1][mario.x + 1] != 3) {
                    mario.jumpcounter = 2; //falling after peak
                    mario.jumpcounterprev = 3;
                    level[mario.y][mario.x] = 0;
                    mario.x++;
                    mario.y++;
                    level[mario.y][mario.x] = 21;
                }
                else {
                    mario.jumpcounter = 0; //landed on platform at peak
                    mario.jumpcounterprev = 0;
                    level[mario.y][mario.x] = 0;
                    mario.x++;
                    level[mario.y][mario.x] = 17;
                }
                return 0;
            }
            else if(mario.jumpcounter == 2 && mario.jumpcounterprev == 3) {
                if(level[mario.y + 1][mario.x + 1] != 1 && level[mario.y + 1][mario.x + 1] != 2 && level[mario.y + 1][mario.x + 1] != 3) {
                    mario.jumpcounter = 1;
                    mario.jumpcounterprev = 2;
                    level[mario.y][mario.x] = 0;
                    mario.x++;
                    mario.y++;
                    level[mario.y][mario.x] = 21;
                    return 2;
                }
                else {
                    mario.jumpcounter = 0; //platform in path, still
                    mario.jumpcounterprev = 0;
                    level[mario.y][mario.x] = 0;
                    level[mario.y][mario.x] = 17;
                    return 0;
                }
            }
            else if(mario.jumpcounter == 1 && mario.jumpcounterprev == 2) {
                if(level[mario.y + 1][mario.x + 1] != 1 && level[mario.y + 1][mario.x + 1] != 2 && level[mario.y + 1][mario.x + 1] != 3) {
                    mario.jumpcounter = 0; //back at level where jump started
                    mario.jumpcounterprev = 1;
                    level[mario.y][mario.x] = 0;
                    mario.x++;
                    mario.y++;
                    level[mario.y][mario.x] = 21;
                    return 2;
                }
                else {
                    mario.jumpcounter = 0; //platform in path, still
                    mario.jumpcounterprev = 0;
                    level[mario.y][mario.x] = 17;
                    return 0;
                }
            }
            else {
                if(level[mario.y + 1][mario.x + 1] != 1 && level[mario.y + 1][mario.x + 1] != 2 && level[mario.y + 1][mario.x + 1] != 3) {
                    mario.jumpcounter = 0; //keep falling
                    mario.jumpcounterprev = 0;
                    level[mario.y][mario.x] = 0;
                    mario.x++;
                    mario.y++;
                    level[mario.y][mario.x] = 21;
                    return 2;
                }
                else {
                    mario.jumpcounter = 0; //stop falling
                    mario.jumpcounterprev = 0;
                    level[mario.y][mario.x] = 0;
                    mario.x++;
                    level[mario.y][mario.x] = 17;
                    return 0;
                }
            }
        }
    }

    public static void crouch(int[][] level, Mario mario) {
        if(mario.type == 0) {
            return;
        }
        if(mario.direction == 0) {
            if(mario.type == 1) {
                level[mario.y][mario.x] = 28;
            }
            else {
                level[mario.y][mario.x] = 29;
            }
        }
        else {
            if(mario.type == 1) {
                level[mario.y][mario.x] = 36;
            }
            else {
                level[mario.y][mario.x] = 37;
            }
        }
    }
    public static void fireball(int[][] level, Mario mario) {
        if(mario.type == 2) {
            if(mario.direction == 0) {
                level[mario.y][mario.x - 1] = 41;
            }
            else {
                level[mario.y][mario.x + 1] = 41;
            }
        }
    }
    public void run()
    {
        System.out.println("Running " +  threadName );
        try
        {
            for(int i = 0; i < 300; i++) {
                Thread.sleep(50);
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
        if (mario == null)
        {
            mario = new Thread (this, threadName);
            mario.start ();

        }
    }
}
