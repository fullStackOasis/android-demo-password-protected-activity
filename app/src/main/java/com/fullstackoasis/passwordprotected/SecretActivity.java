package com.fullstackoasis.passwordprotected;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

/**
 * A secret activity that can only be accessed via a (hardcoded!) password.
 * A dialog pops up during the onCreate method, and the Activity finishes or continues depending
 * on the password entered.
 */
public class SecretActivity extends AppCompatActivity {
    private static String secretPassword = "ABC12345"; // hardcoded password, yutz!
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret_empty);
        showPasswordDialog();
    }

    private void showPasswordDialog() {
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_password, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);

        builder.setMessage(R.string.enter_password);

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog.
                // Start counting down again.
                SecretActivity.this.finish();
            }
        });

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog.
                // Start counting down again.
                EditText et = dialogView.findViewById(R.id.passwordEditText);
                String password = et.getText().toString();
                if (secretPassword.equals(password)) {
                    dialog.dismiss();
                    SecretActivity.this.setContentView(R.layout.activity_secret);
                } else {
                    SecretActivity.this.finish();
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}

