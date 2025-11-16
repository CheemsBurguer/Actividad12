package com.poupoumpany.actividad12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView statusText;
    private MaterialButton authenticateButton;
    private BiometricHelper biometricHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusText = findViewById(R.id.statusText);
        authenticateButton = findViewById(R.id.authenticateButton);

        biometricHelper = new BiometricHelper(this);

        authenticateButton.setOnClickListener(view -> {
            checkBiometricSupportAndAuthenticate();
        });
    }

    private void checkBiometricSupportAndAuthenticate() {
        int canAuthenticate = biometricHelper.canAuthenticate();

        switch (canAuthenticate) {
            case BiometricHelper.BIOMETRIC_SUCCESS:
                biometricHelper.showBiometricPrompt(this, authenticationCallback);
                break;
            case BiometricHelper.BIOMETRIC_ERROR_NO_HARDWARE:
                updateStatus(getString(R.string.biometric_no_hardware), R.color.error_red);
                break;
            case BiometricHelper.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                updateStatus(getString(R.string.biometric_not_supported), R.color.error_red);
                break;
            case BiometricHelper.BIOMETRIC_ERROR_NONE_ENROLLED:
                updateStatus(getString(R.string.biometric_not_enrolled), R.color.warning_amber);
                Toast.makeText(this, "Por favor, registra una huella en los ajustes de tu dispositivo.", Toast.LENGTH_LONG).show();
                break;
        }
    }

    private final BiometricPrompt.AuthenticationCallback authenticationCallback = new BiometricPrompt.AuthenticationCallback() {
        @Override
        public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
            super.onAuthenticationSucceeded(result);
            updateStatus(getString(R.string.auth_success), R.color.success_green);
        }

        @Override
        public void onAuthenticationFailed() {
            super.onAuthenticationFailed();
            updateStatus(getString(R.string.auth_failed), R.color.error_red);
        }

        @Override
        public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
            super.onAuthenticationError(errorCode, errString);
            if (errorCode == BiometricPrompt.ERROR_USER_CANCELED) {
                updateStatus(getString(R.string.auth_canceled), R.color.warning_amber);
            } else {
                updateStatus(getString(R.string.auth_error) + ": " + errString, R.color.error_red);
            }
        }
    };

    private void updateStatus(String text, int colorResId) {
        statusText.setText(text);
        statusText.setTextColor(ContextCompat.getColor(this, colorResId));
    }
}