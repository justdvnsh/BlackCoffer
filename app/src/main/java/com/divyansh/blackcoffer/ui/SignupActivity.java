package com.divyansh.blackcoffer.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.divyansh.blackcoffer.R;
import com.divyansh.blackcoffer.ui.LoginActivity;
import com.divyansh.blackcoffer.ui.PhoneNumberActivity;
import com.divyansh.blackcoffer.viewModels.SignupViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignupActivity extends AppCompatActivity {

    @BindView(R.id.email_signup)
    EditText email;
    @BindView(R.id.password_signup)
    EditText password;
    @BindView(R.id.agree_privacy_policy)
    RadioButton agreePrivacyPolicy;

    private SignupViewModel signUpViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ButterKnife.bind(this);

        initViewModel();
    }

    private void initViewModel() {
        signUpViewModel = new ViewModelProvider(this).get(SignupViewModel.class);
    }

    @OnClick(R.id.signup_button_signupActivity)
    public void signup(){
        if (email.getText().toString() == "") {
            Toast.makeText(this, "Fill Out the fields", Toast.LENGTH_SHORT).show();
        }

        if (password.getText().toString() == "") {
            Toast.makeText(this, "Fill Out the fields", Toast.LENGTH_SHORT).show();
        }

        if (!agreePrivacyPolicy.isChecked()) {
            Toast.makeText(this, "Agree to privacy policy first", Toast.LENGTH_SHORT).show();
        } else {
            signUpViewModel.signUp(email.getText().toString(), password.getText().toString());
        }
    }

    @OnClick(R.id.login_text)
    public void startLogin() {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }
}
