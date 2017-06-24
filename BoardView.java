package com.example.christian.supermarioassignment_4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.ArrayList;

public class BoardView extends SurfaceView implements SurfaceHolder.Callback {
    private Bitmap icons[];
    private int X;
    private int Y;
    private boolean gamestillrunning = true;
    private int intscore = 0;
    private int intlives = 3;
    private int inttime = 300;
    public ArrayList<Integer> indices = new ArrayList<Integer>();
    private Mario mario;
    private KoopaParatroopa green1;
    private BuzzyBeetle bb1;
    public PiranhaPlant pp1;
    public Level level = new Level();
    public int[][] levelarray = level.loadLevel(level.level1);
    public int mariojumping = 0;





    BoardView(Context context) {
        super(context);
        getHolder().addCallback(this);
        setFocusable(true);
        System.out.println("Constructor");

        for (int i = 3; i < level.eqheight; i++) {
            System.out.println();
            for (int j = 3* level.eqwidth; j < level.eqwidth * 4; j++) {
                int tmpVal = levelarray[i][j];
                System.out.print(levelarray[i][j]);
                indices.add(tmpVal);
            }
        }


        icons = new Bitmap[50];

    }

    @Override
    public void onDraw(Canvas canvas) {
        System.out.println("onDraw()");
        canvas.drawColor(Color.WHITE);
        int width = getWidth();
        int height = getHeight() - 45;
        int columnwidth = width/19;
        int rowheight = height/20;

        if(mario == null) {
            mario = new Mario(66, 8, 0);
            mario.start();
        }
        if(green1 == null) {
            green1 = new KoopaParatroopa(40, 8, 0);
            green1.start();
        }
        if(bb1 == null) {
            bb1 = new BuzzyBeetle(20, 8);
            bb1.start();
        }
        if(pp1 == null) {
            for(int i = 0; i < level.eqheight; i++) {
                for(int j = 0; j < level.eqwidth; j++) {
                    if(levelarray[i][j] == 4) {
                        levelarray[i - 1][j] = 5;
                    }
                }
            }
        }
        Rect rect = new Rect();
        for (int i = 1; i < level.eqheight; i++) {
            for (int j = 0; j < level.eqwidth; j++) {
                rect.set(j * columnwidth, i * rowheight, (j + 1) * columnwidth, (i + 1) * rowheight);
                Paint q = new Paint(Color.WHITE);
                if(indices.get(i * level.eqheight + j) == 0) {
                    canvas.drawBitmap(icons[0], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 1) {
                    canvas.drawBitmap(icons[1], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 2) {
                    canvas.drawBitmap(icons[2], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 3) {
                    canvas.drawBitmap(icons[3], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 4) {
                    canvas.drawBitmap(icons[4], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 5) {
                    canvas.drawBitmap(icons[5], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 6) {
                    canvas.drawBitmap(icons[6], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 7) {
                    canvas.drawBitmap(icons[7], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 8) {
                    canvas.drawBitmap(icons[8], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 9) {
                    canvas.drawBitmap(icons[9], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 10) {
                    canvas.drawBitmap(icons[10], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 11) {
                    canvas.drawBitmap(icons[11], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 12) {
                    canvas.drawBitmap(icons[12], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 13) {
                    canvas.drawBitmap(icons[13], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 14) {
                    canvas.drawBitmap(icons[14], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 15) {
                    canvas.drawBitmap(icons[15], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 16) {
                    canvas.drawBitmap(icons[16], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 17) {
                    canvas.drawBitmap(icons[17], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 18) {
                    canvas.drawBitmap(icons[18], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 19) {
                    canvas.drawBitmap(icons[19], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 20) {
                    canvas.drawBitmap(icons[20], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 21) {
                    canvas.drawBitmap(icons[21], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 22) {
                    canvas.drawBitmap(icons[22], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 23) {
                    canvas.drawBitmap(icons[23], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 24) {
                    canvas.drawBitmap(icons[24], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 25) {
                    canvas.drawBitmap(icons[25], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 26) {
                    canvas.drawBitmap(icons[26], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 27) {
                    canvas.drawBitmap(icons[27], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 28) {
                    canvas.drawBitmap(icons[28], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 29) {
                    canvas.drawBitmap(icons[29], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 30) {
                    canvas.drawBitmap(icons[30], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 31) {
                    canvas.drawBitmap(icons[31], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 32) {
                    canvas.drawBitmap(icons[32], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 33) {
                    canvas.drawBitmap(icons[33], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 34) {
                    canvas.drawBitmap(icons[34], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 35) {
                    canvas.drawBitmap(icons[35], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 36) {
                    canvas.drawBitmap(icons[36], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 37) {
                    canvas.drawBitmap(icons[37], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 38) {
                    canvas.drawBitmap(icons[38], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 39) {
                    canvas.drawBitmap(icons[39], null, rect, q);
                }
                else if(indices.get(i * level.eqheight + j) == 40) {
                    canvas.drawBitmap(icons[40], null, rect, q);
                }
                else{
                    canvas.drawBitmap(icons[41], null, rect, q);
                }
            }
        }


        Paint p = new Paint(Color.WHITE);
        p.setTextSize(45);
        String score = ""+intscore;
        p.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(score, 25, 0, p);
        String lives = ""+intlives;
        canvas.drawText(lives, width/3, 0, p);
        String time = ""+inttime;
        canvas.drawText(time, 2*width/3, 0, p);
        rect.set(0, height/2, width/3, height);
        Paint q = new Paint(Color.BLACK);
        canvas.drawBitmap(icons[13], null, rect, q);
        rect.set(width/2, height/2, 3*width/4, height);
        canvas.drawBitmap(icons[14], null, rect, q);
        rect.set(3*width/4, height/2, width, height);
        canvas.drawBitmap(icons[15], null, rect, q);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        System.out.println("SurfaceCreated()");
        setWillNotDraw(false);

        icons[0] = BitmapFactory.decodeResource(getResources(), R.mipmap.black);
        icons[1] = BitmapFactory.decodeResource(getResources(), R.mipmap.block);
        icons[2] = BitmapFactory.decodeResource(getResources(), R.mipmap.randomblock);
        icons[3] = BitmapFactory.decodeResource(getResources(), R.mipmap.emptyrandomblock);
        icons[4] = BitmapFactory.decodeResource(getResources(), R.mipmap.pipe);
        icons[5] = BitmapFactory.decodeResource(getResources(), R.mipmap.piranhaplant);
        icons[6] = BitmapFactory.decodeResource(getResources(), R.mipmap.buzzybeetleleft);
        icons[7] = BitmapFactory.decodeResource(getResources(), R.mipmap.buzzybeetleright);
        icons[8] = BitmapFactory.decodeResource(getResources(), R.mipmap.buzzybeetleshell);
        icons[9] = BitmapFactory.decodeResource(getResources(), R.mipmap.greenkoopaparatroopa);
        icons[10] = BitmapFactory.decodeResource(getResources(), R.mipmap.greenshell);
        icons[11] = BitmapFactory.decodeResource(getResources(), R.mipmap.redkoopaparatroopa);
        icons[12] = BitmapFactory.decodeResource(getResources(), R.mipmap.redshell);
        icons[13] = BitmapFactory.decodeResource(getResources(), R.mipmap.dpad);
        icons[14] = BitmapFactory.decodeResource(getResources(), R.mipmap.a);
        icons[15] = BitmapFactory.decodeResource(getResources(), R.mipmap.b);
        icons[16] = BitmapFactory.decodeResource(getResources(), R.mipmap.mariostillleft);
        icons[17] = BitmapFactory.decodeResource(getResources(), R.mipmap.mariostillright);
        icons[18] = BitmapFactory.decodeResource(getResources(), R.mipmap.mariowalkleft);
        icons[19] = BitmapFactory.decodeResource(getResources(), R.mipmap.mariowalkright);
        icons[20] = BitmapFactory.decodeResource(getResources(), R.mipmap.mariojumpleft);
        icons[21] = BitmapFactory.decodeResource(getResources(), R.mipmap.mariojumpright);
        icons[22] = BitmapFactory.decodeResource(getResources(), R.mipmap.supermariostillleft);
        icons[23] = BitmapFactory.decodeResource(getResources(), R.mipmap.supermariostillright);
        icons[24] = BitmapFactory.decodeResource(getResources(), R.mipmap.supermariowalkleft);
        icons[25] = BitmapFactory.decodeResource(getResources(), R.mipmap.supermariowalkright);
        icons[26] = BitmapFactory.decodeResource(getResources(), R.mipmap.supermariojumpleft);
        icons[27] = BitmapFactory.decodeResource(getResources(), R.mipmap.supermariojumpright);
        icons[28] = BitmapFactory.decodeResource(getResources(), R.mipmap.supermariocrouchleft);
        icons[29] = BitmapFactory.decodeResource(getResources(), R.mipmap.supermariocrouchright);
        icons[30] = BitmapFactory.decodeResource(getResources(), R.mipmap.firemariostillleft);
        icons[31] = BitmapFactory.decodeResource(getResources(), R.mipmap.firemariostillright);
        icons[32] = BitmapFactory.decodeResource(getResources(), R.mipmap.firemariowalkleft);
        icons[33] = BitmapFactory.decodeResource(getResources(), R.mipmap.firemariowalkright);
        icons[34] = BitmapFactory.decodeResource(getResources(), R.mipmap.firemariojumpleft);
        icons[35] = BitmapFactory.decodeResource(getResources(), R.mipmap.firemariojumpright);
        icons[36] = BitmapFactory.decodeResource(getResources(), R.mipmap.firemariocrouchleft);
        icons[37] = BitmapFactory.decodeResource(getResources(), R.mipmap.firemariocrouchright);
        icons[38] = BitmapFactory.decodeResource(getResources(), R.mipmap.supermushroom);
        icons[39] = BitmapFactory.decodeResource(getResources(), R.mipmap.fireflower);
        icons[40] = BitmapFactory.decodeResource(getResources(), R.mipmap.coin);
        icons[41] = BitmapFactory.decodeResource(getResources(), R.mipmap.fireball);


    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("touch event");

        int width = (getWidth());
        int height = (getHeight());
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            X = (int) event.getX();
            Y = (int) event.getY();
            if (X >= 0 && X <= width / 8 && Y >= height/2 && Y <= 2*height / 3) {
                //jump left
                mario.leftjumping(levelarray, mario);
                mariojumping = 1;
                System.out.println("jump left");
            } else if (X >= width / 8 && X <= width / 4 && Y >= height / 2 && Y <= 2* height / 3) {
                //jump right
                mario.rightjumping(levelarray, mario);
                mariojumping = 1;
                System.out.println("jump right");
            }else if (X >= width / 9 && X <= 2* width / 9 && Y >= 3*height/4 && Y <= height) {
                //crouch
                mario.crouch(levelarray, mario);
                System.out.println("crouch");
            }
            else if (X >= 0 && X <= width / 8 && Y >= height/2 && Y <= height) {
                //move left
                mario.direction = 0;
                System.out.println("move left");
            } else if (X >= 2*width / 9 && X <= width / 3 && Y >= height/2 && Y <= height) {
                //move right
                mario.direction = 1;
                System.out.println("move right");
            } else if (X >= 3*width / 4 && X <= width && Y >= height/2 && Y <= height) {
                //fireball
                mario.fireball(levelarray, mario);
                System.out.println("fireball");
            } else if (X >= width / 2 && X <= 3*width/4 && Y >= height/2 && Y <= height) {
                //jump
                mario.fireball(levelarray, mario);
                mariojumping = 3;
                System.out.println("jump");
            } else {
                //do nothing
            }

        }
        else{
            while(mariojumping == 1) {
                mariojumping = mario.leftjumping(levelarray, mario);
            }
            while(mariojumping == 2) {
                mariojumping = mario.rightjumping(levelarray, mario);
            }
            while(mariojumping == 3) {
                mariojumping = mario.verticaljumping(levelarray, mario);
            }
        }
        indices.clear();
        for (int i = 3; i < level.eqheight; i++) {
            System.out.println();
            for (int j = 3* level.eqwidth; j < level.eqwidth * 4; j++) {
                int tmpVal = levelarray[i][j];
                System.out.print(levelarray[i][j]);
                indices.add(tmpVal);
            }
        }
        invalidate();
        return false;
    }
}

