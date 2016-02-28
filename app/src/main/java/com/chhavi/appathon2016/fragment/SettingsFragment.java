package com.chhavi.appathon2016.fragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.chhavi.appathon2016.R;

/**
 * QuickBlox team
 */
public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
