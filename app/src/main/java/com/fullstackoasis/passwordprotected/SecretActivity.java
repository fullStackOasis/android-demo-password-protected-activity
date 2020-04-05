package com.fullstackoasis.passwordprotected;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * A secret activity that can only be accessed via a (hardcoded!) password.
 */
public class SecretActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret);
    }
}

