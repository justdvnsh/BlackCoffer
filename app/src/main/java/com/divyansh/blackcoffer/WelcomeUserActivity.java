package com.divyansh.blackcoffer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

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
}
