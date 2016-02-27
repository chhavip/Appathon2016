package com.chhavi.appathon2016.blind;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

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

        mySfg.setOnFingerGestureListener(new SimpleFingerGestures.OnFingerGestureListener() {
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

        layout.setOnTouchListener(mySfg);
    }
}
