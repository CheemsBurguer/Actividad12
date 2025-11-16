package com.poupoumpany.actividad12;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import java.util.concurrent.Executor;

public class BiometricHelper {

    public static final int BIOMETRIC_SUCCESS = BiometricManager.BIOMETRIC_SUCCESS;
    public static final int BIOMETRIC_ERROR_NO_HARDWARE = BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE;
    public static final int BIOMETRIC_ERROR_HW_UNAVAILABLE = BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE;
    public static final int BIOMETRIC_ERROR_NONE_ENROLLED = BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED;

    private final Context context;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;

    public BiometricHelper(@NonNull Context context) {
        this.context = context;
    }

    public int canAuthenticate() {
        BiometricManager biometricManager = BiometricManager.from(context);
        return biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG);
    }

    public void showBiometricPrompt(@NonNull AppCompatActivity activity, @NonNull BiometricPrompt.AuthenticationCallback authenticationCallback) {
        Executor executor = ContextCompat.getMainExecutor(context);

        biometricPrompt = new BiometricPrompt(activity, executor, authenticationCallback);

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle(context.getString(R.string.biometric_prompt_title))
                .setSubtitle(context.getString(R.string.biometric_prompt_subtitle))
                .setDescription(context.getString(R.string.biometric_prompt_description))
                .setNegativeButtonText(context.getString(R.string.biometric_prompt_negative_button))
                .build();
        
        biometricPrompt.authenticate(promptInfo);
    }
}
