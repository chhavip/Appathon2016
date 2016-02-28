package com.chhavi.appathon2016.blind;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chhavi.appathon2016.Extras.OnDoubleTapListener;
import com.chhavi.appathon2016.Extras.OnSwipeTouchListener;
import com.chhavi.appathon2016.MainActivity;
import com.chhavi.appathon2016.R;

import in.championswimmer.sfg.lib.SimpleFingerGestures;

/**
 * Created by chhavi on 28/2/16.
 */
public class UserInteractionActivity extends AppCompatActivity {

    private SimpleFingerGestures mySfg = new SimpleFingerGestures();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_interaction);
        LinearLayout layout = (LinearLayout)findViewById(R.id.linearLayout);

        //TODO have the activity call out the available three types of functionalities
        //first is to double tap -- connect to call
        //second is left swipe -- record a video for feedback
        //third is right swipr -- book an appointment (for later use)


        TextView text = (TextView)findViewById(R.id.textViewTest);


/*
        text.setOnTouchListener(new OnDoubleTapListener(this) {

            @Override

            public void onDoubleTap(MotionEvent e) {

                Toast.makeText(UserInteractionActivity.this, "Double Tap", Toast.LENGTH_SHORT).show();

            }

        });*/

        text.setOnTouchListener(new OnSwipeTouchListener(this) {


            @Override

            public void onSwipeLeft() {

                Toast.makeText(UserInteractionActivity.this, "Left", Toast.LENGTH_SHORT).show();

                //TODO give option to record video for fututre opinion
            }



            @Override

            public void onSwipeUp() {

                Toast.makeText(UserInteractionActivity.this, "Up", Toast.LENGTH_SHORT).show();
                //TODO connect to call in swipe up


            }



            @Override

            public void onSwipeRight() {

                Toast.makeText(UserInteractionActivity.this, "Right", Toast.LENGTH_SHORT).show();

                //TODO make an appointment
            }

        });


     /*   mySfg.setOnFingerGestureListener(new SimpleFingerGestures.OnFingerGestureListener() {
            @Override
            public boolean onSwipeUp(int i, long l, double v) {
                return false;
            }

            @Override
            public boolean onSwipeDown(int i, long l, double v) {
                Log.e("Double Tapped", "Connect to call");
                return false;
            }

            @Override
            public boolean onSwipeLeft(int i, long l, double v) {
                Log.e("Double Tapped", "Connect to call");
                return false;
            }

            @Override
            public boolean onSwipeRight(int i, long l, double v) {
                Log.e("Double Tapped", "Connect to call");
                return false;
            }

            @Override
            public boolean onPinch(int i, long l, double v) {
                return false;
            }

            @Override
            public boolean onUnpinch(int i, long l, double v) {
                return false;
            }

            @Override
            public boolean onDoubleTap(int i) {
                Log.e("Double Tapped", "Connect to call");
                return true;
            }

        });

        layout.setOnTouchListener(mySfg);*/
    }
}
