package com.fullstackoasis.passwordprotected;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * MainActivity has a text message and a Button. Clicking the button sends you to SecretActivity.
 * However, the SecretActivity does not display any information to start with. Instead, it shows
 * a blank page, and a Dialog pops up asking you for a password. If you enter the correct
 * password, then your secret information will be displayed in the SecretActivity via a change of
 * layout. If the password is incorrect, the SecretActivity finishes, and you are returned to
 * MainActivity. See helpful StackOverflow message:
 * https://stackoverflow.com/questions/9043899/simple-password-protect-your-android-application
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecretActivity.class);
                MainActivity.this.startActivity(i);
            }
        });
    }
}
