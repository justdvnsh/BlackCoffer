package com.divyansh.blackcoffer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.signup_button_signupActivity)
    public void signup(){
        startActivity(new Intent(getApplicationContext(), PhoneNumberActivity.class));
    }

    @OnClick(R.id.login_text)
    public void startLogin() {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }
}
