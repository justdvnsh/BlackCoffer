package com.divyansh.blackcoffer.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.divyansh.blackcoffer.R;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhoneNumberActivity extends AppCompatActivity {

    @BindView(R.id.mobile_number_edit_text)
    EditText mobileNumber;
    PhoneAuthProvider phoneAuthProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);

        ButterKnife.bind(this);

        phoneAuthProvider = PhoneAuthProvider.getInstance();
    }

    private boolean validateFields() {
        if (mobileNumber.getText().length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @OnClick(R.id.mobile_number_submit_btn)
    public void startVerification() {
        if (validateFields()) {
            phoneAuthProvider.verifyPhoneNumber(
                    "+91 " + mobileNumber.getText().toString(),
                    60,
                    TimeUnit.SECONDS,
                    this,
                    new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                        @Override
                        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                            Log.i("Credetial", phoneAuthCredential.toString());
                        }

                        @Override
                        public void onVerificationFailed(@NonNull FirebaseException e) {
                            Log.i("error->", e.getMessage());
                            Toast.makeText(getApplication(), "Failed", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                            super.onCodeSent(s, forceResendingToken);
                            Toast.makeText(getApplicationContext(), "Code Sent", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), VerificationActivity.class);
                            intent.putExtra("verificationId", s);
                            startActivity(intent);
                        }
                    }
            );
        } else {
            Toast.makeText(getApplicationContext(), "Please Enter your Number !", Toast.LENGTH_SHORT).show();
        }
    }
}
