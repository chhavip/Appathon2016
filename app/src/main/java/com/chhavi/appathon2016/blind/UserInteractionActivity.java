package com.chhavi.appathon2016.blind;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
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

import java.util.HashMap;
import java.util.Locale;

import in.championswimmer.sfg.lib.SimpleFingerGestures;

/**
 * Created by chhavi on 28/2/16.
 */
public class UserInteractionActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    TextToSpeech textToSpeech;
    private SimpleFingerGestures mySfg = new SimpleFingerGestures();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_interaction);
        getSupportActionBar().hide();
      //  LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);

        textToSpeech = new TextToSpeech(getApplicationContext(), this);

        //TODO have the activity call out the available three types of functionalities
        //first is to double tap -- connect to call
        //second is left swipe -- record a video for feedback
        //third is right swipr -- book an appointment (for later use)


        TextView text = (TextView) findViewById(R.id.textViewTest);


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
                startActivity(new Intent(UserInteractionActivity.this, MakeAppointment.class));
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

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("error", "This Language is not supported");
            } else {

                textToSpeech.setOnUtteranceCompletedListener(new TextToSpeech.OnUtteranceCompletedListener() {

                    @Override
                    public void onUtteranceCompleted(String utteranceId) {
                        Log.e("error", "This Language is not supported");

                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {

                            }
                        });

                    }
                });

                HashMap<String, String> params = new HashMap<String, String>();

                params.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "stringId");
                // convertTextToSpeech("Hello and welcome, would you like to register as Volunteer or seak assistance? Say out loud Volunteer or Help according to your choice after the beep");
                textToSpeech.speak("Swipe Up to connect to volunteer right now, Swipe left to record video, Swipe Right to make an appointment for future assistance", TextToSpeech.QUEUE_FLUSH, params);

            }
        }

    }

}
