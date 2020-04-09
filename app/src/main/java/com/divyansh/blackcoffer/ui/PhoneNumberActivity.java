package com.divyansh.blackcoffer.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.divyansh.blackcoffer.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhoneNumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.mobile_number_submit_btn)
    public void startVerification() {
        startActivity(new Intent(getApplicationContext(), VerificationActivity.class));
    }
}
