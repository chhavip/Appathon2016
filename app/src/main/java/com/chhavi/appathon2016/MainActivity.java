package com.chhavi.appathon2016;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener, TextToSpeech.OnUtteranceCompletedListener {

    private final int CHECK_CODE = 0x1;
    private final int LONG_DURATION = 5000;
    private final int SHORT_DURATION = 1200;

    TextToSpeech textToSpeech;
   // private Speaker speaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textToSpeech = new TextToSpeech(getApplicationContext(), this);
     //   checkTTS();


       // speaker.allow(true);


      //  speaker.speak(text);

        textToSpeech.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            @Override
            public void onStart(String utteranceId) {
                Toast.makeText(MainActivity.this, "asdd", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onDone(String utteranceId) {
                Log.e("Yeah", utteranceId);
                Toast.makeText(MainActivity.this, "asdd", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(String utteranceId) {

            }
        });
    }

    private void checkTTS() {
        Intent check = new Intent();
        check.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(check, CHECK_CODE);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
       // speaker.destroy();
    }
    private void convertTextToSpeech(String text) {
        //  String text = inputText.getText().toString();
        if (null == text || "".equals(text)) {
            text = "Please give some input.";
        }
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
       /* textToSpeech.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            @Override
            public void onStart(String utteranceId) {
                Toast.makeText(MainActivity.this, "asdd", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onDone(String utteranceId) {
                Log.e("Yeah", utteranceId);
                Toast.makeText(MainActivity.this, "asdd", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(String utteranceId) {

            }
        });*/
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
                                Toast.makeText(MainActivity.this, "asdd", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });

        HashMap<String, String> params = new HashMap<String, String>();

        params.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID,"stringId");
               // convertTextToSpeech("Hello and welcome, would you like to register as Volunteer or seak assistance? Say out loud Volunteer or Help according to your choice after the beep");
                textToSpeech.speak("Hello and welcome, would you like to register as Volunteer or seak assistance? Say out loud Volunteer or Help according to your choice after the beep", TextToSpeech.QUEUE_FLUSH, params);

            }


        }

        else {
            Log.e("error", "Initilization Failed!");
        }
    }

    @Override
    public void onUtteranceCompleted(String utteranceId) {

    }
}