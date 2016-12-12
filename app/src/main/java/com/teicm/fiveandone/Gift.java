package com.teicm.fiveandone;

import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Gift extends AppCompatActivity {

    MediaPlayer bkgrdmsc;

    private TextView scoreLabel;
    private TextView startLabel;
    private ImageView zombie;
    private ImageView orange;
    private ImageView pink;
    private ImageView blue;


    private int frameHeight;
    private int zombieSize;
    private int screenWidth;
    private int screenHeight;


    private int zombieY;
    private int orangeX;
    private int orangeY;
    private int pinkX;
    private int pinkY;
    private int blueX;
    private int blueY;


    private int zombieSpeed;
    private int orangeSpeed;
    private int pinkSpeed;
    private int blueSpeed;


    private int score = 0;


    private Handler handler = new Handler();
    private Timer timer = new Timer();


    private boolean action_flg = false;
    private boolean start_flg = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift);

        bkgrdmsc = MediaPlayer.create(Gift.this, R.raw.music);
        bkgrdmsc.setLooping(true);
        bkgrdmsc.start();

        scoreLabel = (TextView) findViewById(R.id.scoreLabel);
        startLabel = (TextView) findViewById(R.id.startLabel);
        zombie = (ImageView) findViewById(R.id.zombie);
        orange = (ImageView) findViewById(R.id.orange);
        pink = (ImageView) findViewById(R.id.pink);
        blue = (ImageView) findViewById(R.id.blue);


        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);

        screenWidth = size.x;
        screenHeight = size.y;

        zombieSpeed = Math.round(screenHeight / 60);
        orangeSpeed = Math.round(screenWidth / 60);
        pinkSpeed = Math.round(screenWidth / 36);
        blueSpeed = Math.round(screenWidth / 45);



        orange.setX(80);
        orange.setY(80);
        pink.setX(80);
        pink.setY(80);
        blue.setX(80);
        blue.setY(80);

        scoreLabel.setText("Score : 0");


    }


    public void changePos() {

        hitCheck();

        orangeX -= orangeSpeed;
        if (orangeX < 0) {
            orangeX = screenWidth + 20;
            orangeY = (int) Math.floor(Math.random() * (frameHeight - orange.getHeight()));
        }
        orange.setX(orangeX);
        orange.setY(orangeY);



        blueX -= blueSpeed;
        if (blueX < 0) {
            blueX = screenWidth + 10;
            blueY = (int) Math.floor(Math.random() * (frameHeight - blue.getHeight()));
        }
        blue.setX(blueX);
        blue.setY(blueY);


        pinkX -= pinkSpeed;
        if (pinkX < 0) {
            pinkX = screenWidth + 5000;
            pinkY = (int) Math.floor(Math.random() * (frameHeight - pink.getHeight()));
        }
        pink.setX(pinkX);
        pink.setY(pinkY);



        if (action_flg == true) {

            zombieY -= zombieSpeed;

        } else {

            zombieY += zombieSpeed;
        }


        if (zombieY < 0) zombieY = 0;

        if (zombieY > frameHeight - zombieSize) zombieY = frameHeight - zombieSize;

        zombie.setY(zombieY);

        scoreLabel.setText("Score : " + score);

    }


    public void hitCheck() {


        int orangeCenterX = orangeX + orange.getWidth() / 2;
        int orangeCenterY = orangeY + orange.getHeight() / 2;


        if (0 <= orangeCenterX && orangeCenterX <= zombieSize &&
                zombieY <= orangeCenterY && orangeCenterY <= zombieY + zombieSize) {

            score += 10;
            orangeX = -10;


        }


        int pinkCenterX = pinkX + pink.getWidth() / 2;
        int pinkCenterY = pinkY + pink.getHeight() / 2;

        if (0 <= pinkCenterX && pinkCenterX <= zombieSize &&
                zombieY <= pinkCenterY && pinkCenterY <= zombieY + zombieSize) {

            score += 30;
            pinkX = -10;

        }


        int blueCenterX = blueX + blue.getWidth() / 2;
        int blueCenterY = blueY + blue.getHeight() / 2;

        if (0 <= blueCenterX && blueCenterX <= zombieSize &&
                zombieY <= blueCenterY && blueCenterY <= zombieY + zombieSize) {


            timer.cancel();
            timer = null;



            Intent intent = new Intent(getApplicationContext(),Result.class);
            intent.putExtra("SCORE", score);
            startActivity(intent);

        }



    }


    public boolean onTouchEvent(MotionEvent me) {

        if (start_flg == false) {

            start_flg = true;


            FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
            frameHeight = frame.getHeight();

            zombieY = (int)zombie.getY();

            zombieSize = zombie.getHeight();


            startLabel.setVisibility(View.GONE);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            changePos();
                        }
                    });
                }
            }, 0, 20);


        } else {
            if (me.getAction() == MotionEvent.ACTION_DOWN) {
                action_flg = true;

            } else if (me.getAction() == MotionEvent.ACTION_UP) {
                action_flg = false;
            }
        }

        return true;
    }



    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    return true;
            }
        }

        return super.dispatchKeyEvent(event);
    }
    @Override
    protected void onPause(){
        super.onPause();
        bkgrdmsc.release();
        finish();
    }

}