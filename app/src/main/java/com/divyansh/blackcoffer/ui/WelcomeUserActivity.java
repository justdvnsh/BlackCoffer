package com.divyansh.blackcoffer.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.divyansh.blackcoffer.R;
import com.divyansh.blackcoffer.ui.LoginActivity;
import com.divyansh.blackcoffer.ui.SignupActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeUserActivity extends AppCompatActivity {

    @BindView(R.id.imageViewWelcomeScreen)
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_user);

        ButterKnife.bind(this);

        image.setImageResource(R.drawable.women);
    }

    @OnClick(R.id.signup)
    public void startSignup() {
        startActivity(new Intent(getApplicationContext(), SignupActivity.class));
    }

    @OnClick(R.id.login_text)
    public void startLogin() {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }
}
