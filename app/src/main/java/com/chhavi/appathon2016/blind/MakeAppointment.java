package com.chhavi.appathon2016.blind;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.chhavi.appathon2016.R;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by chhavi on 28/2/16.
 */
public class MakeAppointment extends AppCompatActivity implements TextToSpeech.OnInitListener {
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.make_an_appointment);
        textToSpeech = new TextToSpeech(getApplicationContext(), this);

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
                            //    textToSpeech.speak("Give us a date", TextToSpeech.QUEUE_FLUSH, null);
                                //TODO take user input of date, start time and end time
                            }
                        });

                    }
                });

                HashMap<String, String> params = new HashMap<String, String>();

                params.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "stringId");
                // convertTextToSpeech("Hello and welcome, would you like to register as Volunteer or seak assistance? Say out loud Volunteer or Help according to your choice after the beep");
                textToSpeech.speak("Give us a date, start time and end time", TextToSpeech.QUEUE_FLUSH, null);

            }
        }

    }
    }

