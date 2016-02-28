package com.chhavi.appathon2016.blind;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chhavi.appathon2016.Extras.OnSwipeTouchListener;
import com.chhavi.appathon2016.R;
import com.chhavi.appathon2016.volunteer.VolunteerSignUpActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by chhavi on 28/2/16.
 */
public class MakeAppointment extends AppCompatActivity implements TextToSpeech.OnInitListener {
    TextToSpeech textToSpeech;
    EditText userInput;

    private final int CHECK_CODE = 0x1;
    private final int LONG_DURATION = 5000;
    private final int SHORT_DURATION = 1200;

    private final int REQ_CODE_SPEECH_INPUT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.make_an_appointment);
        textToSpeech = new TextToSpeech(getApplicationContext(), this);
        userInput = (EditText)findViewById(R.id.user_input_text);


        TextView text = (TextView) findViewById(R.id.textViewTest);


        text.setOnTouchListener(new OnSwipeTouchListener(this) {

            @Override

            public void onSwipeUp() {

                Toast.makeText(MakeAppointment.this, "Up", Toast.LENGTH_SHORT).show();
                //TODO connect to call in swipe up
                finish();


            }


        });

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
                                userInput();
                            }
                        });

                    }
                });

                HashMap<String, String> params = new HashMap<String, String>();

                params.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "stringId");
                // convertTextToSpeech("Hello and welcome, would you like to register as Volunteer or seak assistance? Say out loud Volunteer or Help according to your choice after the beep");
                textToSpeech.speak("Give us a date, start time and end time so we can make an appointment for you,  or Swipe up to go back", TextToSpeech.QUEUE_FLUSH, null);

            }
        }

    }

    private void userInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Say Something");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    "Speech not supported",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    userInput.setText(result.get(0));
                    textToSpeech.speak("Your request for" + result.get(0) + "has been recorded", TextToSpeech.QUEUE_ADD, null);
                    //txtSpeechInput.setText(result.get(0));

                    }
                }
                break;
            }

        }
    }

