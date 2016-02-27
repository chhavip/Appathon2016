package com.chhavi.appathon2016;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by chhavi on 28/2/16.
 */
public class UserSignUp extends AppCompatActivity implements TextToSpeech.OnInitListener{
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_sign_up);
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
                                //UI changes
                                Toast.makeText(UserSignUp.this, "asdd", Toast.LENGTH_LONG).show();


                                //TODO : add a method to take in user name and register him/her, after registeration go to activity with three input methods
                                userRegisteration();


                            }
                        });

                    }
                });

                HashMap<String, String> params = new HashMap<String, String>();

                params.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID,"stringId");
                // convertTextToSpeech("Hello and welcome, would you like to register as Volunteer or seak assistance? Say out loud Volunteer or Help according to your choice after the beep");
                   textToSpeech.speak("Please Tell Us your name", TextToSpeech.QUEUE_FLUSH, params);

            }


        } else {
            Log.e("error", "Initilization Failed!");
        }
    }

    public void userRegisteration(){

        //TODO: on successful registeration

        Intent i = new Intent(UserSignUp.this, UserInteractionActivity.class);
    }
}
