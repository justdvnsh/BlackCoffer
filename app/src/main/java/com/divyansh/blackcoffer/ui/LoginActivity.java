package com.divyansh.blackcoffer.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.divyansh.blackcoffer.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.login_btn_loginActivity)
    public void startLogin(){
        startActivity(new Intent(getApplicationContext(), PhoneNumberActivity.class));
    }

    @OnClick(R.id.signup_text_login)
    public void startSignup() {
        startActivity(new Intent(getApplicationContext(), SignupActivity.class));
    }
}
